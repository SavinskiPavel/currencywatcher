package com.example.currencywatcher.management.api.client.web.constructor;

import com.example.currencywatcher.management.api.client.web.resource.ClientOutResource;
import com.example.currencywatcher.management.api.cryptocurrency.web.constructor.CryptocurrencyOutResourceConstructor;
import com.example.currencywatcher.persistence.client.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClientOutResourceConstructor {

    @Autowired
    private CryptocurrencyOutResourceConstructor constructor;

    public ClientOutResource construct(ClientEntity entity) {

        return ClientOutResource.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .fixedCryptocurrencyPrice(entity.getFixedCryptocurrencyPrice())
                .subscriptionTs(entity.getSubscriptionTs())
                .cryptocurrencies(entity.getCryptocurrencies().stream()
                        .filter(Objects::nonNull)
                        .map(cryptocurrencyEntity -> constructor.construct(cryptocurrencyEntity))
                        .collect(Collectors.toList()))
                .build();
    }
}
