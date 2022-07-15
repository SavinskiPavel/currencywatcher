package com.example.currencywatcher.management.api.cryptocurrency.web.constructor;

import com.example.currencywatcher.management.api.cryptocurrency.web.resource.CryptocurrencyOutResource;
import com.example.currencywatcher.persistence.cryptocurrency.CryptocurrencyEntity;
import org.springframework.stereotype.Service;

@Service
public class CryptocurrencyOutResourceConstructor {

    public CryptocurrencyOutResource construct(CryptocurrencyEntity entity) {

        return CryptocurrencyOutResource.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .priceUsd(entity.getPriceUsd())
                .build();
    }
}
