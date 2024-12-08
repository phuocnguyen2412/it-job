package exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Lỗi phía người dùng!");
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
