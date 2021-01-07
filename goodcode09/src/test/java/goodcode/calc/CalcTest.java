package goodcode.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    @Test
    public void testPlus() {
        assertEquals(3, Calc.plus(1, 2));
        assertEquals(-2, Calc.plus(5, -7));
    }
}