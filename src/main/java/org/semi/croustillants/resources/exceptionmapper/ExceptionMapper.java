package org.semi.croustillants.resources.exceptionmapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anthony on 14/11/16.
 */
@ControllerAdvice
class ExceptionMapper {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /*@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleNotFound(final HttpServletRequest req, final ResourceNotFoundException e) {
        logger.debug("ResourceNotFoundException caught", e);
        final ErrorMessage err = ErrorMessage.builder()
                .exception(e)
                .request(req)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }*/

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(final HttpServletRequest req, final IllegalArgumentException e) {
        logger.debug("IllegalArgumentException caught", e);
        final ErrorMessage err = ErrorMessage.builder()
                .exception(e)
                .request(req)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleThrowable(final HttpServletRequest req, final Throwable e) {
        logger.debug("Unexpected exception caught", e);
        final ErrorMessage err = ErrorMessage.builder()
                .exception(e)
                .request(req)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
