package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsOkExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_null_exception() {
        new IsOkExpr(null);
    }

    @Test
    public void evaluate_zero_false() {
        var expr = new IsOkExpr(inputs -> BigDecimal.ZERO);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }

    @Test
    public void evaluate_ten_true() {
        var expr = new IsOkExpr(inputs -> BigDecimal.TEN);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }
}