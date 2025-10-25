package com.dev.brexchangeapi.exceptions;

public class ErrorCoinNotFound extends RuntimeException {
    public ErrorCoinNotFound(String message) {
        super(message);
    }
}
