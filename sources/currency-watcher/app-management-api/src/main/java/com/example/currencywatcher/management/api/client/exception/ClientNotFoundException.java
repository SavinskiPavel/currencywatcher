package com.example.currencywatcher.management.api.client.exception;

import com.example.currencywatcher.management.cmn.exception.EntityNotFoundException;

public class ClientNotFoundException extends EntityNotFoundException {

    public ClientNotFoundException(String message) {
        super(message);
    }
}
