package com.example.G2.Exceptionhandler;

import com.example.G2.Model.Error;
import com.example.G2.exception.APIIntegrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class APIIntegrationExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(APIIntegrationExceptionHandler.class);

    @ExceptionHandler(APIIntegrationException.class)
    public ResponseEntity<Error> APIIntegrationErrorHandler(APIIntegrationException exception) {
        logger.error(exception.getStackTrace().toString());
        ResponseEntity<Error> responseEntity = new ResponseEntity<>(exception.getError(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
