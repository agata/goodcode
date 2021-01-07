package goodcode.converter;

import org.apache.commons.lang3.StringUtils;

public class TrimConverter implements Converter {
	public Object convert(Object value) {
		return StringUtils.trimToEmpty(value.toString());
	}
}
