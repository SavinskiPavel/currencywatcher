package com.example.currencywatcher.management.cmn.exception;

public abstract class EntityNotFoundException extends ManagementApiException {

    public EntityNotFoundException(String message) {
        super(message, 404);
    }
}
