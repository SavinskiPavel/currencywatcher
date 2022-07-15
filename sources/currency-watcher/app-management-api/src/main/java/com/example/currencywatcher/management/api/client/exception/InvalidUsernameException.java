package com.example.currencywatcher.management.api.client.exception;

import com.example.currencywatcher.management.cmn.exception.ManagementApiException;

public class InvalidUsernameException extends ManagementApiException {

    public InvalidUsernameException(String message) {
        super(message, 400);
    }
}
