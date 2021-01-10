package goodcode.step1;

import goodcode.util.ByteArray;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * リスト10.1 ベタなコード
 */
public class Main {
	public static void main(String[] args) throws Exception {
		byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		MessageParser parser = new MessageParser(messages);
		parser.parse();
	}

	private static class MessageParser {
		private int index = 0;
		private final ByteArray bytes;
		
		public MessageParser(byte[] bytes) {
			this.bytes = new ByteArray(bytes);
		}
		
		public void parse() {
			while (index < bytes.getLength() - 1) {
				Map<String, Object> record = new HashMap<String, Object>();
				record.put("送信日", toDate(getString(8)));
				record.put("ユーザ名", trim(getString(10)));
				record.put("メールアドレス", trim(getString(20)));
				record.put("ポイント", toInt(trim(getString(5))));
				System.out.println(record);
			}
		}
		
		private String getString(int length) {
			String value = bytes.getString(index, length);
			index += length;
			return value;
		}
	}
	
	private static Integer toInt(String value) {
		return Integer.parseInt(value);
	}

	private static String trim(String value) {
		return StringUtils.trimToEmpty(value);
	}

	private static Date toDate(String value) {
		try {
			return new SimpleDateFormat("yyyyMMdd").parse(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
