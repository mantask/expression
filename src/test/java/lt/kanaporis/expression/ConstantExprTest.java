package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ConstantExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_null_exception() {
        new ConstantExpr(null);
    }

    @Test
    public void evaluate_constant_constant() {
        var expr = new ConstantExpr(new BigDecimal("123.45"));
        assertEquals(new BigDecimal("123.45"), expr.evaluate(Collections.emptyMap()));
    }
}