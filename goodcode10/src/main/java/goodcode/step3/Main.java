package goodcode.step3;

import goodcode.converter.Converter;
import goodcode.util.ByteArray;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.seasar.extension.dataset.DataRow;
import org.seasar.extension.dataset.DataTable;
import org.seasar.extension.dataset.impl.XlsReader;

/**
 * Step3:リフレクションAPIを使用して変換ルールを動的に実行する
 */
public class Main {
	public static void main(String[] args) throws Exception {
		byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		DataTable config = new XlsReader(new File("config.xls")).read().getTable(0);
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
					Class<?> clazz = Class.forName(ruleClassName);
					Converter converter = (Converter)clazz.newInstance();
					Object newValue = converter.convert(value);
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
