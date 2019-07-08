package lt.kanaporis.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@AllArgsConstructor
@Getter
class OrExpr implements Expr<Boolean> {
    @NonNull
    private final Expr<Boolean> left;

    @NonNull
    private final Expr<Boolean> right;

    @Override
    public Boolean evaluate(@NonNull final Map<String, String> inputs) {
        return left.evaluate(inputs) || right.evaluate(inputs);
    }
}
