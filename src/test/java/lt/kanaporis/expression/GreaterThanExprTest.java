package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GreaterThanExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new GreaterThanExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new GreaterThanExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_tenGtOne_true() {
        var expr = new GreaterThanExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }

    @Test
    public void evaluate_oneGtTen_false() {
        var expr = new GreaterThanExpr(inputs -> BigDecimal.ONE, inputs -> BigDecimal.TEN);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }

    @Test
    public void evaluate_oneGtOne_false() {
        var expr = new GreaterThanExpr(inputs -> BigDecimal.ONE, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }
}