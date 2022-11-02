package other;

public class NotEnteredException extends RuntimeException{
    public NotEnteredException() {
    }

    public NotEnteredException(String message) {
        super(message);
    }

    public NotEnteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnteredException(Throwable cause) {
        super(cause);
    }

    public NotEnteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
