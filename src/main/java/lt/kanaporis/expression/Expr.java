package lt.kanaporis.expression;

import java.util.Map;

@FunctionalInterface
public interface Expr<T> {
    T evaluate(Map<String, String> inputs);
}
