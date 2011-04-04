package goodcode.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter implements Converter {
	public Object convert(Object value) {
		try {
			return new SimpleDateFormat("yyyyMMdd").parse(value.toString());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
