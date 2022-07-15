package com.example.currencywatcher.datasupplier.service;

import com.example.currencywatcher.datasupplier.web.domain.CoinLoreResponse;

public interface CoinLoreResponseFetcher {

    CoinLoreResponse fetch(String url);
}
