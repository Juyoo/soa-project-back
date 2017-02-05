package org.semi.croustillants.exception;

/**
 * Created by raymo on 05/02/2017.
 */
public class RestPaymentServiceException extends RuntimeException {
    private static final long serialVersionUID = -4030462500504547565L;

    public RestPaymentServiceException() {
    }

    public RestPaymentServiceException(final String message) {
        super(message);
    }

    public RestPaymentServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RestPaymentServiceException(final Throwable cause) {
        super(cause);
    }

    public RestPaymentServiceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
