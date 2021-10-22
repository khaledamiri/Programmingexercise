public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return message;
    }

    private final String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

}