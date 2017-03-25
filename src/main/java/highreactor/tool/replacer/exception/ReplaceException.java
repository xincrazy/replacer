package highreactor.tool.replacer.exception;

public class ReplaceException extends RuntimeException {
    public ReplaceException() {
    }

    public ReplaceException(String message) {
        super(message);
    }

    public ReplaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
