package com.example.currencywatcher.datasupplier.web.domain;

public record CoinLoreResponse(
        String id,
        String symbol,
        String name,
        String price_usd
) { }
