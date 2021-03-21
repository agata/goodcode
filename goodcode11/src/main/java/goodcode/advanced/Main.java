package goodcode.advanced;

import static goodcode.advanced.Converters.date;
import static goodcode.advanced.Converters.integer;
import static goodcode.advanced.Converters.trim;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import static goodcode.advanced.Field.field;
import goodcode.converter.Converter;
import goodcode.util.ByteArray;

/**
 * もっとDSLっぽく
 */
public class Main {
	public static void main(final String[] args) throws Exception {
		final byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		List<Map<String,Object>> records = new MessageParser(messages)
			.define(
				field("送信日", 8).to(date),
				field("ユーザ名", 10).to(trim),
				field("メールアドレス", 20).to(trim),
				field("ポイント", 5).to(trim, integer)
			).parse();
	}

	private static class MessageParser {
		private int index = 0;
		private final ByteArray bytes;
		private final List<Field> fields = new ArrayList<Field>();

		public MessageParser(final byte[] bytes) {
			this.bytes = new ByteArray(bytes);
		}

		public MessageParser define(Field ...fields) {
			this.fields.addAll(Arrays.asList(fields));
			return this;
		}

		public List<Map<String,Object>> parse() throws Exception {
			List<Map<String,Object>> records = new ArrayList<Map<String,Object>>();
			while (index < bytes.getLength() - 1) {
				final Map<String, Object> record = new HashMap<String, Object>();
				for (final Field field : fields) {
					final String name = field.name;
					final int length = field.length;
					Object value = getString(length);
					for(Converter converter : field.converters) {
						value = converter.convert(value);
					}
					record.put(name, value);
				}
				System.out.println(record);
				records.add(record);
			}
			return records;
		}

		private String getString(final int length) {
			final String value = bytes.getString(index, length);
			index += length;
			return value;
		}
	}
}
