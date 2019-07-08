package lt.kanaporis.expression;

public class ParseException extends RuntimeException {
    public ParseException(final Throwable cause) {
        super(cause);
    }

    public ParseException(final String message) {
        super(message);
    }
}
