package com.example.G2.Exceptionhandler;

import com.example.G2.Model.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleUnhandledException(Exception exception) {
        logger.error(exception.getStackTrace().toString());
        Error error = Error.create(exception.getMessage(), "UNKNOWN");
        ResponseEntity<Error> responseEntity = new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
