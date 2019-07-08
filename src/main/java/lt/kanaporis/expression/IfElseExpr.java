package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@AllArgsConstructor
@Getter
class IfElseExpr implements Expr<Object> {
    @NonNull
    private final Expr<Boolean> condition;

    @NonNull
    private final Expr thenExpr;

    @NonNull
    private final Expr elseExpr;

    @Override
    @SuppressWarnings("unchecked")
    public Object evaluate(final @NonNull Map<String, String> inputs) {
        if (condition.evaluate(inputs)) {
            return thenExpr.evaluate(inputs);
        } else {
            return elseExpr.evaluate(inputs);
        }
    }
}
