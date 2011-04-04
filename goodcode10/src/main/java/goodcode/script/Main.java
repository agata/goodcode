package goodcode.script;

import goodcode.converter.Converter;
import goodcode.util.ByteArray;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.seasar.extension.dataset.DataRow;
import org.seasar.extension.dataset.DataTable;
import org.seasar.extension.dataset.impl.XlsReader;

/**
 * 考察　変換ルールに引数を追加したい場合は？
 * 式言語やスクリプト言語を利用する(JavaScriptを利用したサンプル)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		DataTable config = new XlsReader(new File("config-scripting.xls")).read().getTable(0);
		MessageParser parser = new MessageParser(messages, config);
		parser.parse();
	}

	private static class MessageParser {
		private int index = 0;
		private final ByteArray bytes;
		private DataTable config;
		
		public MessageParser(byte[] bytes, DataTable config) {
			this.bytes = new ByteArray(bytes);
			this.config = config;
		}
		
		public void parse() throws Exception {
			while (index < bytes.getLength() - 1) {
				Map<String, Object> record = new HashMap<String, Object>();
				for (int i = 0; i < config.getRowSize(); i++) {
					DataRow row = config.getRow(i); 
					String name = (String) row.getValue("データ名称");
					int length = ((BigDecimal) row.getValue("バイト数")).intValue();
					String ruleClassName = (String) row.getValue("変換ルール");
					String value = getString(length);
					
					final ContextFactory contextFactory = ContextFactory.getGlobal();
					final Context cx = contextFactory.enterContext();
					cx.setLanguageVersion(Context.VERSION_1_7);
					Scriptable global = new ImporterTopLevel(cx);
					cx.evaluateString(global, 
							"importPackage(Packages.goodcode.converter);\n" +
							"var result = " + ruleClassName, "evaluate", 1, null);
					Object result = Context.jsToJava(global.get("result", global), Object.class);
					List<Converter> converters = new ArrayList<Converter>();
					if (result instanceof NativeArray) {
						for (Object prop : NativeArray.getPropertyIds((ScriptableObject)result)) {
							Converter converter = (Converter) ((NativeJavaObject)ScriptableObject.getProperty((Scriptable)result, (Integer)prop)).unwrap();
							converters.add(converter);
						}
					} else {
						converters.add((Converter) result);
					}
					Object newValue = value;
					for (Converter converter : converters) {
						newValue = converter.convert(newValue);
					}
					record.put(name, newValue);
				}
				System.out.println(record);
			}
		}

		private String getString(int length) {
			String value = bytes.getString(index, length);
			index += length;
			return value;
		}
	}
}
