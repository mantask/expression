package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AddExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new AddExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new AddExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_tenPlusOne_eleven() {
        var expr = new AddExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertEquals(new BigDecimal("11"), result);
    }
}