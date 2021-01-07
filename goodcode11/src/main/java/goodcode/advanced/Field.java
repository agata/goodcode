package goodcode.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import goodcode.converter.Converter;

public class Field {
    public final String name;
    public final int length;
    public final List<Converter> converters = new ArrayList<Converter>();

    public Field(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Field to(Converter ...converters) {
        this.converters.addAll(Arrays.asList(converters));
        return this;
    }

    public static Field field(String name, int length) {
        return new Field(name, length);
    }
}
