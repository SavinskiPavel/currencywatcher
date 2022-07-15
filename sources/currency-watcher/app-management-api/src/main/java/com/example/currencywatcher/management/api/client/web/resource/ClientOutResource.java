package com.example.currencywatcher.management.api.client.web.resource;

import com.example.currencywatcher.management.api.cryptocurrency.web.resource.CryptocurrencyOutResource;
import com.example.currencywatcher.management.api.client.exception.InvalidUsernameException;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record ClientOutResource(
        Long id,
        String username,
        String fixedCryptocurrencyPrice,
        LocalDateTime subscriptionTs,
        List<CryptocurrencyOutResource> cryptocurrencies
) {
    @Builder
    public ClientOutResource {
        if (username.isBlank())
            throw new InvalidUsernameException("Username should be not empty");
    }
}
