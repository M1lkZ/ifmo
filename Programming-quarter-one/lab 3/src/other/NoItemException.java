package other;

public class NoItemException extends RuntimeException{
    public NoItemException() {
    }

    public NoItemException(String message) {
        super(message);
    }

    public NoItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoItemException(Throwable cause) {
        super(cause);
    }

    public NoItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
