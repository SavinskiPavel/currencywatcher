package com.example.currencywatcher.management.api.client.exception;

import com.example.currencywatcher.management.cmn.exception.ConflictException;

public class UsernameIsNotUniqueException extends ConflictException {

    public UsernameIsNotUniqueException(String message) {
        super(message);
    }
}
