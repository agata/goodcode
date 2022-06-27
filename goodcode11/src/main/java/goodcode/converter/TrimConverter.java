package goodcode.converter;

public class TrimConverter implements Converter {
	public Object convert(Object value) {
		return value.toString().trim();
	}
}
