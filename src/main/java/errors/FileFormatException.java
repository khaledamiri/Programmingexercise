package errors;

public class FileFormatException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return message;
    }

    private final String message;

    public FileFormatException(String message) {
        super(message);
        this.message = message;
    }

}