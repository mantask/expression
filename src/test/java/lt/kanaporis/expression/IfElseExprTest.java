package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class IfElseExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_conditionNull_exception() {
        new IfElseExpr(null, inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_thenNull_exception() {
        new IfElseExpr(inputs -> true, null, inputs -> BigDecimal.ONE);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_elseNull_exception() {
        new IfElseExpr(inputs -> true, inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_ifTrue_then() {
        var expr = new IfElseExpr(inputs -> true, inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertEquals(BigDecimal.TEN, result);
    }

    @Test
    public void evaluate_ifFalse_else() {
        var expr = new IfElseExpr(inputs -> false, inputs -> BigDecimal.TEN, inputs -> BigDecimal.ONE);
        var result = expr.evaluate(Collections.emptyMap());
        assertEquals(BigDecimal.ONE, result);
    }
}