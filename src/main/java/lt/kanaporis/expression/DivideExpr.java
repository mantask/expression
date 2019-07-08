package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@AllArgsConstructor
@Getter
class DivideExpr implements Expr<BigDecimal> {
    @NonNull
    private final Expr<BigDecimal> left;

    @NonNull
    private final Expr<BigDecimal> right;

    @Override
    public BigDecimal evaluate(final @NonNull Map<String, String> inputs) {
        return left.evaluate(inputs).divide(right.evaluate(inputs), 2, RoundingMode.HALF_UP);
    }
}
