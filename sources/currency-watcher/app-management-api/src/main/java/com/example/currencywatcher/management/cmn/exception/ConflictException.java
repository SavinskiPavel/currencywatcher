package com.example.currencywatcher.management.cmn.exception;

public abstract class ConflictException extends ManagementApiException {

    public ConflictException(String message) {
        super(message, 409);
    }
}
