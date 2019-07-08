package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
class SubtractExpr implements Expr<BigDecimal> {
    @NonNull
    private final Expr<BigDecimal> left;

    @NonNull
    private final Expr<BigDecimal> right;

    @Override
    public BigDecimal evaluate(final @NonNull Map<String, String> inputs) {
        return left.evaluate(inputs).subtract(right.evaluate(inputs));
    }
}
