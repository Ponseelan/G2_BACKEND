package com.example.G2.exception;

import com.example.G2.Model.Error;


public class APIIntegrationException extends RuntimeException {
    private final Error error;

    public APIIntegrationException(Error error) {
        this.error = error;
    }

    public Error getError() {

        return this.error;
    }
}
