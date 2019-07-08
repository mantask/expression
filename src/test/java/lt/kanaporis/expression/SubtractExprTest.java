package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SubtractExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new SubtractExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new SubtractExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_tenMinusOne_nine() {
        var expr = new SubtractExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertEquals(new BigDecimal("9"), result);
    }
}