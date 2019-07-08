# Expression

The component implements a compiler for parsing and evaluating simple Lisp style expressions.


## Expression Language


This component parses and evaluates expressions like:

    (? (< (? (IsOk finalcurr) finalcurr 0) (? (IsOk paymentcurr) paymentcurr 0)) (/ sum 3.4528) sum)

... or:

    (? (xor (IsOk sum) sum) (= formError 2) 0)

... or:

    (? (< (? (IsOk cntdiff1) cntdiff1 0) -0.01) 0 (= formError 1))(? (xor (IsOk cntfrom1) (IsOk cntdiff1)) (= formError 2) 0)

... or:

    (- cntto4 cntfrom4)

... or:

    (? (xor (IsOk sum) sum) (= formError 2) 0)


## Sample Usage

See `lt.kanaporis.expression.ExpressionEvaluationTest` for sample usage:

    var parser = new Parser();
    var expr = parser.parse("(? (> (? (IsOk finalcurr) finalcurr 0) (? (IsOk paymentcurr) paymentcurr 0)) (/ sum 3.4528) sum)");
    var result = expr.evaluate(Map.of(
            "finalcurr", "333",
            "paymentcurr", "111",
            "sum", "100"));
    // result <- new BigDecimal("28.96")
