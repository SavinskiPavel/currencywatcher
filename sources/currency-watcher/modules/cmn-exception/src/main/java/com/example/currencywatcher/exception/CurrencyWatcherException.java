package com.example.currencywatcher.exception;

import lombok.Getter;

@Getter
public class CurrencyWatcherException extends RuntimeException {

    private final int statusCode;

    public CurrencyWatcherException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public CurrencyWatcherException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
