package goodcode.mapping;

import goodcode.converter.Converter;
import goodcode.util.ByteArray;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.seasar.extension.dataset.DataRow;
import org.seasar.extension.dataset.DataTable;
import org.seasar.extension.dataset.impl.XlsReader;

/**
 * 考察　DSLの構文を改善するには？
 * 変換ルールに短い別名を付ける
 */
public class Main {
	public static void main(String[] args) throws Exception {
		byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		DataTable config = new XlsReader(new File("config-mapping.xls")).read().getTable(0);
		Properties ruleClassNameMapping = new Properties();
		ruleClassNameMapping.load(new FileInputStream("mapping.properties"));
		MessageParser parser = new MessageParser(messages, config, ruleClassNameMapping);
		parser.parse();
	}

	private static class MessageParser {
		private int index = 0;
		private final ByteArray bytes;
		private DataTable config;
		private Properties ruleClassNameMapping;
		
		public MessageParser(byte[] bytes, DataTable config, Properties ruleClassNameMapping) {
			this.bytes = new ByteArray(bytes);
			this.config = config;
			this.ruleClassNameMapping = ruleClassNameMapping;
		}
		
		public void parse() throws Exception {
			while (index < bytes.getLength() - 1) {
				Map<String, Object> record = new HashMap<String, Object>();
				for (int i = 0; i < config.getRowSize(); i++) {
					DataRow row = config.getRow(i); 
					String name = (String) row.getValue("データ名称");
					int length = ((BigDecimal) row.getValue("バイト数")).intValue();
					String alias = (String) row.getValue("変換ルール");
					String ruleClassName = findRuleClassName(alias);
					String value = getString(length);
					Class<?> clazz = Class.forName(ruleClassName);
					Converter converter = (Converter)clazz.newInstance();
					Object newValue = converter.convert(value);
					record.put(name, newValue);
				}
				System.out.println(record);
			}
		}
		
		private String findRuleClassName(String alias) {
			String ruleClassName = this.ruleClassNameMapping.getProperty(alias);
			if (ruleClassName == null) {
				throw new RuntimeException("alias not found. : alias=" + alias);
			}
			return ruleClassName;
		}

		private String getString(int length) {
			String value = bytes.getString(index, length);
			index += length;
			return value;
		}
	}
}
