package lt.kanaporis.expression;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ParserTest {
    private Parser parser = new Parser();

    @Test(expected = ParseException.class)
    public void parse_null_exception() throws ParseException {
        parser.parse("");
    }

    @Test
    public void parse_empty_success() throws ParseException {
        var result = parser.parse("0");
        assertTrue(result instanceof ConstantExpr);
    }

    @Test
    public void parse_realWorld_parsed() throws ParseException {
        var result = parser.parse("(? (> (? (IsOk finalcurr) finalcurr 0) (? (IsOk paymentcurr) paymentcurr 0)) (/ sum 3.4528) sum)");

        assertTrue(result instanceof IfElseExpr);
        assertTrue(((IfElseExpr) result).getCondition() instanceof GreaterThanExpr);
        assertTrue(((IfElseExpr) result).getThenExpr() instanceof DivideExpr);
        assertTrue(((DivideExpr) ((IfElseExpr) result).getThenExpr()).getLeft() instanceof VariableExpr);
        assertTrue(((DivideExpr) ((IfElseExpr) result).getThenExpr()).getRight() instanceof ConstantExpr);
        assertTrue(((IfElseExpr) result).getElseExpr() instanceof VariableExpr);
    }

    // TODO(MK): Add more tests
}