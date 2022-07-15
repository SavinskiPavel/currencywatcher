package com.example.currencywatcher.management.api.client.web.constructor;

import com.example.currencywatcher.persistence.cryptocurrency.CryptocurrencyEntity;
import com.example.currencywatcher.persistence.client.ClientEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientEntityConstructor {

    public ClientEntity construct(String username, CryptocurrencyEntity cryptocurrencyEntity) {

        var customerEntity = new ClientEntity();

        customerEntity.setUsername(username);
        customerEntity.setFixedCryptocurrencyPrice(cryptocurrencyEntity.getPriceUsd());
        customerEntity.getCryptocurrencies().add(cryptocurrencyEntity);

        return customerEntity;
    }
}
