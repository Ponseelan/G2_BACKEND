package com.example.G2.Model;

public class Error {
    public String message;
    public String action;

    private Error(String message, String action) {
        this.message = message;
        this.action = action;
    }

    public static Error create(String message, String action) {
        return new Error(message, action);
    }
}
