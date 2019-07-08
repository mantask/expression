package lt.kanaporis.expression;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class Parser {
    public Expr parse(@NonNull final String expression) {
        try (var tokenizer = new Tokenizer(expression)) {
            return parse(tokenizer);
        } catch (final NoSuchElementException e) {
            throw new ParseException(e);
        }
    }

    @SuppressWarnings({"unchecked"})
    private Expr parse(final Tokenizer tokenizer) {
        var term = tokenizer.next();
        if (term.equals("(")) {
            Expr expr;
            switch (tokenizer.next()) {
                case "xor":
                    expr = new XorExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "or":
                    expr = new OrExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "?":
                    expr = new IfElseExpr(parse(tokenizer), parse(tokenizer), parse(tokenizer));
                    break;
                case "IsOk":
                    expr = new IsOkExpr(parse(tokenizer));
                    break;
                case ">":
                    expr = new GreaterThanExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "<":
                    expr = new LessThanExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "=":
                    expr = new EqualsExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "/":
                    expr = new DivideExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "*":
                    expr = new MultiplyExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "+":
                    expr = new AddExpr(parse(tokenizer), parse(tokenizer));
                    break;
                case "-":
                    expr = new SubtractExpr(parse(tokenizer), parse(tokenizer));
                    break;
                default:
                    throw new ParseException("Unexpected operator: " + tokenizer.next());
            }

            if (!")".equals(tokenizer.next())) {
                throw new IllegalStateException("Syntax error: ) expected.");
            }

            return expr;
        } else if (Tokenizer.CONSTANT_REGEX.matcher(term).matches()) {
            return new ConstantExpr(new BigDecimal(term));
        } else if (Tokenizer.VARIABLE_REGEX.matcher(term).matches()) {
            return new VariableExpr(term);
        } else {
            throw new ParseException("Unexpected term: " + term);
        }
    }
}
