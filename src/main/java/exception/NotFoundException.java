package exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("The requested resource was not found.");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}