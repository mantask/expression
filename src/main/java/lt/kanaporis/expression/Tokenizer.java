package lt.kanaporis.expression;

import lombok.NonNull;

import java.io.Closeable;
import java.util.Scanner;
import java.util.regex.Pattern;

class Tokenizer implements Closeable {
    private static final String PARENTHESIS_OPEN = "\\(";
    private static final String PARENTHESIS_CLOSE = "\\)";
    private static final String OPERATOR_XOR = "xor";
    private static final String OPERATOR_OR = "or";
    private static final String OPERATOR_IF = "\\?";
    private static final String OPERATOR_IS_OK = "IsOK";
    private static final String OPERATOR_GREATER_THAN = ">";
    private static final String OPERATOR_LESS_THAN = "<";
    private static final String OPERATOR_EQUALS = "=";
    private static final String OPERATOR_DIVIDE = "/";
    private static final String OPERATOR_MULTIPLY = "\\*";
    private static final String OPERATOR_ADD = "\\+";
    private static final String OPERATOR_SUBTRACT = "-";
    private static final String CONSTANT = "-?\\d+(\\.(\\d+)?)?";
    private static final String VARIABLE = "\\w+";
    private static final Pattern GRAMMAR_REGEX = Pattern.compile("("
            + PARENTHESIS_OPEN + "|"
            + PARENTHESIS_CLOSE + "|"
            + OPERATOR_XOR + "|"
            + OPERATOR_OR + "|"
            + OPERATOR_IF + "|"
            + OPERATOR_IS_OK + "|"
            + OPERATOR_GREATER_THAN + "|"
            + OPERATOR_LESS_THAN + "|"
            + OPERATOR_EQUALS + "|"
            + OPERATOR_DIVIDE + "|"
            + OPERATOR_MULTIPLY + "|"
            + OPERATOR_ADD + "|"
            + OPERATOR_SUBTRACT + "|"
            + CONSTANT + "|"
            + VARIABLE + ")");
    static final Pattern CONSTANT_REGEX = Pattern.compile(CONSTANT);
    static final Pattern VARIABLE_REGEX = Pattern.compile(VARIABLE);
    private final Scanner scanner;

    Tokenizer(@NonNull final String input) {
        var spacedInput = input
                .replace("(", "( ")
                .replace(")", " )");
        this.scanner = new Scanner(spacedInput);
    }

    String next() {
        return scanner.next(GRAMMAR_REGEX);
    }

    @Override
    public void close() {
        scanner.close();
    }
}
