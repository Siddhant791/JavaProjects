package src.exception;

public class MyCustomException extends RuntimeException {
    public MyCustomException (){}
    public MyCustomException (String message) {
        super(message);
    }
    public MyCustomException(String message, Throwable cause){
        super(message, cause);
    }
    public MyCustomException(String message, Throwable cause, boolean enableSuppression, boolean writeTraceBack){
        super(message,cause, enableSuppression, writeTraceBack);
    }
}
