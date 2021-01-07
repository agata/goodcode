package goodcode.converter;


public class IntegerConverter implements Converter {
	public Object convert(Object value) {
		return Integer.parseInt(value.toString());
	}
}
