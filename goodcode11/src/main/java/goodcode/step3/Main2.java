package goodcode.step3;

import goodcode.converter.Converter;
import goodcode.converter.DateConverter;
import goodcode.converter.IntegerConverter;
import goodcode.converter.TrimConverter;
import goodcode.util.ByteArray;

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * 変換ルールを実行する（MessageParserをテスト可能にした）
 */
public class Main2 {
	public static Fields fields = new Fields()
		.define(new Field("送信日", 8, new DateConverter()))
		.define(new Field("ユーザ名", 10, new TrimConverter()))
		.define(new Field("メールアドレス", 20, new TrimConverter()))
		.define(new Field("ポイント", 5, new IntegerConverter()));


	public static void main(String[] args) throws Exception {
		byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		MessageParser parser = new MessageParser(messages, fields);
		parser.parse();
	}

	public static class MessageParser {
		private int index = 0;
		private final ByteArray bytes;
		private final Fields fields;
		
		public MessageParser(byte[] bytes, Fields fields) {
			this.bytes = new ByteArray(bytes);
			this.fields = fields;
		}

		public List<Map<String,Object>> parse() throws Exception {
			var records = new ArrayList<Map<String,Object>>();
			while (index < bytes.getLength() - 1) {
				var record = new HashMap<String, Object>();
				for (Field field : fields.fields) {
					String name = field.name;
					int length = field.length;
					Converter converter = field.converter;
					String value = getString(length);
					Object newValue = converter.convert(value);
					record.put(name, newValue);
				}
				records.add(record);
			}
			return records;
		}
		
		private String getString(int length) {
			String value = bytes.getString(index, length);
			index += length;
			return value;
		}
	}

	private static class Field {
		public final String name;
		public final int length;
		public final Converter converter;

		public Field(String name, int length, Converter converter) {
			this.name = name;
			this.length = length;
			this.converter = converter;
		}
	}

	private static class Fields {
		private List<Field> fields = new ArrayList<Field>();

		public Fields define(Field field) {
			this.fields.add(field);
			return this;
		}
	}
}
