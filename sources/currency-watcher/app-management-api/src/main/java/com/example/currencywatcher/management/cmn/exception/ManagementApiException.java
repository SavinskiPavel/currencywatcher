package com.example.currencywatcher.management.cmn.exception;

import com.example.currencywatcher.exception.CurrencyWatcherException;

public abstract class ManagementApiException extends CurrencyWatcherException {

    public ManagementApiException(String message, Throwable cause, int httpCode) {
        super(message, cause, httpCode);
    }

    public ManagementApiException(String message, int httpCode) {
        super(message, httpCode);
    }
}
