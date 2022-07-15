package com.example.currencywatcher.management.api.cryptocurrency.service;

import com.example.currencywatcher.management.api.cryptocurrency.web.resource.CryptocurrencyOutResource;

import java.util.List;

public interface CryptocurrencyService {

    CryptocurrencyOutResource findById(String id);

    List<CryptocurrencyOutResource> findAll();
}
