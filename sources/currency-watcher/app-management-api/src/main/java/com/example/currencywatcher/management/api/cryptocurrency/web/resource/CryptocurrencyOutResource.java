package com.example.currencywatcher.management.api.cryptocurrency.web.resource;

import lombok.Builder;

public record CryptocurrencyOutResource(
        String id, String symbol, String priceUsd
) {
    @Builder
    public CryptocurrencyOutResource {
    }
}
