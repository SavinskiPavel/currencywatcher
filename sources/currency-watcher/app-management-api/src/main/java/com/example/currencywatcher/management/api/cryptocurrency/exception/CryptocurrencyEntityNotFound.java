package com.example.currencywatcher.management.api.cryptocurrency.exception;

import com.example.currencywatcher.management.cmn.exception.EntityNotFoundException;

public class CryptocurrencyEntityNotFound extends EntityNotFoundException {

    public CryptocurrencyEntityNotFound(String id) {
        super("Cryptocurrency entity not found in database with id: " + id);
    }
}
