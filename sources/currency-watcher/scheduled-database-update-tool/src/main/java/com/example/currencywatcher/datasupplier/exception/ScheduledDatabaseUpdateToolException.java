package com.example.currencywatcher.datasupplier.exception;

public class ScheduledDatabaseUpdateToolException extends RuntimeException {

    public ScheduledDatabaseUpdateToolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScheduledDatabaseUpdateToolException(String message) {
        super(message);
    }
}
