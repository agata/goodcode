package goodcode.advanced;

import goodcode.converter.Converter;
import goodcode.converter.DateConverter;
import goodcode.converter.DateConverter2;
import goodcode.converter.IntegerConverter;
import goodcode.converter.TrimConverter;

public class Converters {
    public static Converter trim = new TrimConverter();
    public static Converter date = new DateConverter();
    public static Converter date(String pattern) {
        return new DateConverter2(pattern);
    }
    public static Converter integer = new IntegerConverter();
}