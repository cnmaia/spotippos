package br.com.cmaia.controller.handler;

import br.com.cmaia.controller.resource.ErrorResource;
import br.com.cmaia.exception.ResourceNotFoundException;
import br.com.cmaia.exception.ValidationException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResource> handleIllegalArgumentException() {
        return new ResponseEntity<>(new ErrorResource("Invalid parameters, please try again."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<ErrorResource> handleNumberFormatException() {
        return new ResponseEntity<>(new ErrorResource("Invalid parameters, please try again with correct types."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResource> handleMethodNotSupported() {
        return new ResponseEntity<>(new ErrorResource("Http method not supported for this operation, " +
                "please check api documentation and try again with correct method."), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResource> handleMediaNotSupported(HttpMediaTypeNotSupportedException e) {
        return new ResponseEntity<>(new ErrorResource("Http media type not supported for this operation, " +
                "please check api documentation and try again with correct type." + e.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResource> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ErrorResource("Resource not found." + e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResource> handleValidationException(ValidationException e) {
        return new ResponseEntity<>(new ErrorResource(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResource> handleGenericException(HttpServletRequest request, Exception ex) {
        logger.error("url='{}'", request.getRequestURI(), ex);
        return new ResponseEntity<>(new ErrorResource("An error occurred in server, please try again later."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
