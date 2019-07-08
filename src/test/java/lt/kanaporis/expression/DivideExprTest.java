package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertThat;

public class DivideExprTest {
    @Test(expected = NullPointerException.class)
    public void evaluate_leftNull_exception() {
        new DivideExpr(null, inputs -> BigDecimal.TEN);
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_rightNull_exception() {
        new DivideExpr(inputs -> BigDecimal.TEN, null);
    }

    @Test
    public void evaluate_twelveDividedByTree_four() {
        var expr = new DivideExpr(inputs -> new BigDecimal("12"), inputs -> new BigDecimal("3"));
        var result = expr.evaluate(Collections.emptyMap());
        assertThat(new BigDecimal("4"), comparesEqualTo(result));
    }
}