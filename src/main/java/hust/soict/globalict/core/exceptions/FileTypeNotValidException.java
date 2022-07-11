package hust.soict.globalict.core.exceptions;

public class FileTypeNotValidException extends Exception{
    public FileTypeNotValidException() {

    }

    public FileTypeNotValidException(String message) {
        super(message);
    }

    public FileTypeNotValidException(Throwable cause) {
        super(cause);
    }

    public FileTypeNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
