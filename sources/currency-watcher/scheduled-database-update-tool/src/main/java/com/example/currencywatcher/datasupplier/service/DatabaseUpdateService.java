package com.example.currencywatcher.datasupplier.service;

import com.example.currencywatcher.datasupplier.web.domain.CoinLoreResponse;

import java.util.List;

public interface DatabaseUpdateService {

    void updateDatabase(List<CoinLoreResponse> dataForUpdate);
}
