package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VariableExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_null_exception() {
        new VariableExpr(null);
    }

    @Test(expected = EvaluationException.class)
    public void evaluate_missing_exception() {
        var expr = new VariableExpr("foo");
        expr.evaluate(Collections.emptyMap());
    }

    @Test
    public void evaluate_provided_resolve() {
        var expr = new VariableExpr("foo");
        var result = expr.evaluate(Map.of("foo", "123.45"));
        assertEquals(new BigDecimal("123.45"), result);
    }
}