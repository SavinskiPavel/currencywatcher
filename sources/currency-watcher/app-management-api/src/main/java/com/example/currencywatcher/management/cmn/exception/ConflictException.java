package com.example.currencywatcher.management.cmn.exception;

import com.example.currencywatcher.exception.CurrencyWatcherException;

public abstract class ConflictException extends CurrencyWatcherException {

    public ConflictException(String message) {
        super(message, 409);
    }
}
