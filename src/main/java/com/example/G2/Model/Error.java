package com.example.G2.Model;

public class Error {
    public String message;
    public String action;

    public Error(String message, String action) {
        this.message = message;
        this.action = action;
    }

    public static Error createError(String message, String action) {
        return new Error(message,action);
    }
}
