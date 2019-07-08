package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new EqualsExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new EqualsExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_tenAndOne_neq() {
        var expr = new EqualsExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }

    @Test
    public void evaluate_tenAndTen_eq() {
        var expr = new EqualsExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.TEN);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }
}