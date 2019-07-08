package lt.kanaporis.expression;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XorExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new XorExpr(null, inputs -> true);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new XorExpr(inputs -> true, null);
    }

    @Test
    public void evaluate_trueXorTrue_false() {
        var expr = new XorExpr(inputs -> true, inputs -> true);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }

    @Test
    public void evaluate_falseXorTrue_true() {
        var expr = new XorExpr(inputs -> false, inputs -> true);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }
}