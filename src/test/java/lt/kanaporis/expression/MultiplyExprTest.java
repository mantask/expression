package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class MultiplyExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new MultiplyExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new MultiplyExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_tenTimesTen_hundred() {
        var expr = new MultiplyExpr(inputs -> BigDecimal.TEN, inputs -> BigDecimal.TEN);
        var result = expr.evaluate(Collections.emptyMap());
        assertEquals(new BigDecimal("100"), result);
    }
}