package exception;


public class ForbiddenException extends RuntimeException {
    public ForbiddenException() {
        super("You do not have permission to access this resource.");
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
