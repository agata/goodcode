package goodcode.converter;

import org.apache.commons.lang.StringUtils;

public class TrimConverter implements Converter {
	public Object convert(Object value) {
		return StringUtils.trim(value.toString());
	}
}
