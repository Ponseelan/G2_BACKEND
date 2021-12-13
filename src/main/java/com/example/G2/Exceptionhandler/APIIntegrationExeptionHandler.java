package com.example.G2.Exceptionhandler;

import com.example.G2.Model.Error;
import com.example.G2.exception.APIIntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class APIIntegrationExceptionHandler {
    @ExceptionHandler(APIIntegrationException.class)
    public ResponseEntity<Error> APIIntegrationErrorHandler(APIIntegrationException exception)
    {
        ResponseEntity<Error> responseEntity=new ResponseEntity<>(exception.getError(),HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
