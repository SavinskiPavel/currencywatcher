package com.example.currencywatcher.datasupplier.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyIdPropertyUrlConstructor implements UrlConstructor {

    private final static String DATA_SOURCE_BASE_URL = "https://api.coinlore.net/api/ticker/?id=";

    @Value("#{'${cryptocurrency.ids}'.split(',')}")
    private List<String> cryptocurrencyIds;

    public List<String> constructUrl() {

        return cryptocurrencyIds.stream()
                .map(id -> DATA_SOURCE_BASE_URL + id.trim())
                .collect(Collectors.toList());
    }
}
