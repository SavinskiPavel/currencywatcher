package com.example.currencywatcher.datasupplier.exception;

public class JsonParsingException extends ScheduledDatabaseUpdateToolException{

    public JsonParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
