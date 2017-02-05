package org.semi.croustillants.exception;

/**
 * Created by raymo on 05/02/2017.
 */
public class RestISheepServiceException extends RuntimeException {
    private static final long serialVersionUID = 4710867092119003990L;

    public RestISheepServiceException() {
    }

    public RestISheepServiceException(String message) {
        super(message);
    }

    public RestISheepServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestISheepServiceException(Throwable cause) {
        super(cause);
    }

    public RestISheepServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
