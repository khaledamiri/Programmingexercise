package errors;

public class ExceedLineNumberException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return message;
    }

    private final String message;

    public ExceedLineNumberException(String message) {
        super(message);
        this.message = message;
    }
}
