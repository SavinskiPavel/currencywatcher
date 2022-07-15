package com.example.currencywatcher.management.api.client.service;

import com.example.currencywatcher.management.api.client.exception.ClientNotFoundException;
import com.example.currencywatcher.persistence.client.ClientEntity;
import com.example.currencywatcher.persistence.client.ClientRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientDatabaseObserver implements DatabaseObserver {

    private static final double ACCEPTABLE_PERCENT = 1.0;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @SneakyThrows
    public void handleUpdatedDb(ClientEntity clientEntity) {

        log.info("Tracking changes in database for {}", clientEntity.getUsername());

        var clientId = clientEntity.getId();

        var clientFromDb = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId.toString()));
        var cryptocurrencyFromDb = clientFromDb.getCryptocurrencies().get(0);

        var oldPrice = clientEntity.getFixedCryptocurrencyPrice();
        var newPrice = cryptocurrencyFromDb.getPriceUsd();

        if (oldPrice == null || newPrice == null) {
            Thread.sleep(2000);
            this.handleUpdatedDb(clientEntity);
        }

        var percentPriceDifference = comparePrices(Double.valueOf(oldPrice), Double.valueOf(newPrice));

        if (percentPriceDifference > ACCEPTABLE_PERCENT) {
            log.info("Currency code - {}. Username - {}. Price changed on {}%.",
                    cryptocurrencyFromDb.getSymbol(), clientEntity.getUsername(), percentPriceDifference);
        }
    }

    private double comparePrices(Double oldPrice, double newPrice) {

        var priceDifference = Math.abs(oldPrice - newPrice);
        return priceDifference / oldPrice * 100.00;
    }
}
