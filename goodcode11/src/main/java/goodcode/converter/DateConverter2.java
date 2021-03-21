package goodcode.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter2 implements Converter {
	
	private final String pattern;

	public DateConverter2(String pattern) {
		this.pattern = pattern;
	}
	
	public Object convert(Object value) {
		try {
			return new SimpleDateFormat(pattern).parse(value.toString());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
