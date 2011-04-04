package goodcode.calc;

import goodcode.calc.Calc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalcTest {
    @Test
    public void testPlus() {
        assertEquals(3, Calc.plus(1, 2));
        assertEquals(-2, Calc.plus(5, -7));
    }
}