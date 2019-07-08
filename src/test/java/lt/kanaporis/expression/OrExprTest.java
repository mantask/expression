package lt.kanaporis.expression;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new OrExpr(null, inputs -> true);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new OrExpr(inputs -> true, null);
    }

    @Test
    public void evaluate_trueOrTrue_false() {
        var expr = new OrExpr(inputs -> true, inputs -> true);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }

    @Test
    public void evaluate_falseOrTrue_true() {
        var expr = new OrExpr(inputs -> false, inputs -> true);
        var result = expr.evaluate(Collections.emptyMap());
        assertTrue(result);
    }

    @Test
    public void evaluate_falseOrFalse_false() {
        var expr = new OrExpr(inputs -> false, inputs -> false);
        var result = expr.evaluate(Collections.emptyMap());
        assertFalse(result);
    }
}