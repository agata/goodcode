package goodcode.step2;

import goodcode.util.ByteArray;

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * リスト10.2 メタデータを内部DSLに移動したコード
 */
public class Main {
	public static void main(String[] args) throws Exception {
		var messages = FileUtils.readFileToByteArray(new File("data.txt"));
		var parser = new MessageParser(messages)
			.define(new Field("送信日", 8))
			.define(new Field("ユーザ名", 10))
			.define(new Field("メールアドレス", 20))
			.define(new Field("ポイント", 5));
		parser.parse();
	}

	private static class MessageParser {
		private int index = 0;
		private final ByteArray bytes;
		private List<Field> fields = new ArrayList<Field>();
		
		public MessageParser(byte[] bytes) {
			this.bytes = new ByteArray(bytes);
		}

		public MessageParser define(Field field) {
			this.fields.add(field);
			return this;
		}
		
		public void parse() throws Exception {
			while (index < bytes.getLength() - 1) {
				var record = new HashMap<String, Object>();
				for (var field : fields) {
					var name = field.name;
					var length = field.length;
					var value = getString(length);
					record.put(name, value);
				}
				System.out.println(record);
			}
		}
		
		private String getString(int length) {
			var value = bytes.getString(index, length);
			index += length;
			return value;
		}
	}

	private static class Field {
		public final String name;
		public final int length;

		public Field(String name, int length) {
			this.name = name;
			this.length = length;
		}
	}
}
