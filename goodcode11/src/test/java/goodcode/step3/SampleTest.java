package goodcode.step3;

import goodcode.step3.Main2.MessageParser;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * 考察　DSLのテストはどうする？
 */
public class SampleTest extends TestCase {
	
	MessageParser parser;
	
	@Override
	protected void setUp() throws Exception {
		byte[] messages = FileUtils.readFileToByteArray(new File("data.txt"));
		parser = new MessageParser(messages, Main2.fields);
	}
	
	@Test
	public void testParse() throws Exception {
		List<Map<String, Object>> records = parser.parse();
		assertEquals("データ件数のチェック", 5, records.size());
		assertEquals("1件目", 
				makeRecord(2008, 11, 1, 10, "user1", "user1@examples.com"), 
				records.get(0));
		assertEquals("2件目", 
				makeRecord(2008, 11, 1, 0, "user2", "user2@examples.com"), 
				records.get(1));
		assertEquals("3件目", 
				makeRecord(2008, 11, 1, 100, "user3", "user3@examples.com"), 
				records.get(2));
		assertEquals("4件目", 
				makeRecord(2008, 11, 2, 80, "user4", "user4@examples.com"), 
				records.get(3));
		assertEquals("5件目", 
				makeRecord(2008, 11, 2, 55, "user5", "user5@examples.com"), 
				records.get(4));
	}
	
	private Map<String, Object> makeRecord(int year, int month, int day, int point,
			String userName, String mailAddress) {
		Map<String, Object> record = new HashMap<String, Object>();
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		Date sendDate = cal.getTime();
		record.put("送信日", sendDate);
		record.put("ポイント", point);
		record.put("ユーザ名", userName);
		record.put("メールアドレス", mailAddress);
		return record;
	}
}
