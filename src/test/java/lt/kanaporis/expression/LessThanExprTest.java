package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LessThanExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new LessThanExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new LessThanExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_tenLtOne_false() {
        var expr = new LessThanExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }

    @Test
    public void evaluate_oneLtTen_true() {
        var expr = new LessThanExpr(inputs -> BigDecimal.ONE, inputs -> BigDecimal.TEN);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }

    @Test
    public void evaluate_oneLtOne_false() {
        var expr = new LessThanExpr(inputs -> BigDecimal.ONE, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }
}