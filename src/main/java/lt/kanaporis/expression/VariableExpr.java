package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
class VariableExpr implements Expr<BigDecimal> {
    @NonNull
    private final String name;

    @Override
    public BigDecimal evaluate(final @NonNull Map<String, String> inputs) {
        var value = inputs.get(name);
        if (value == null) {
            throw new EvaluationException();
        }

        return new BigDecimal(value);
    }
}
