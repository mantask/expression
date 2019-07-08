package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
class IsOkExpr implements Expr<Boolean> {
    @NonNull
    private final Expr<Number> expression;

    @Override
    public Boolean evaluate(final @NonNull Map<String, String> inputs) {
        return !BigDecimal.ZERO.equals(expression.evaluate(inputs));
    }
}
