package lt.kanaporis.expression;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ExpressionEvaluationTest {
    private Parser parser = new Parser();

    @Test
    public void AVON201_amount() {
        var expr = parser.parse("(? (> (? (IsOk finalcurr) finalcurr 0) (? (IsOk paymentcurr) paymentcurr 0)) (/ sum 3.4528) sum)");
        var result = expr.evaluate(Map.of(
                "finalcurr", "333",
                "paymentcurr", "111",
                "sum", "100"));
        assertEquals(new BigDecimal("28.96"), result);
    }

    // TODO(MK): Add more tests
}
