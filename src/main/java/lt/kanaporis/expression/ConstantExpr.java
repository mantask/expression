package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
class ConstantExpr implements Expr<BigDecimal> {
    @NonNull
    private final BigDecimal value;

    @Override
    public BigDecimal evaluate(@NonNull final Map<String, String> inputs) {
        return value;
    }
}
