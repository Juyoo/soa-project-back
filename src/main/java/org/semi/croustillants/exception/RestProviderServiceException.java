package org.semi.croustillants.exception;

/**
 * Created by raymo on 05/02/2017.
 */
public class RestProviderServiceException extends RuntimeException {
    private static final long serialVersionUID = -62398315394772956L;

    public RestProviderServiceException() {
    }

    public RestProviderServiceException(String message) {
        super(message);
    }

    public RestProviderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestProviderServiceException(Throwable cause) {
        super(cause);
    }

    public RestProviderServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

