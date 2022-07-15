package com.example.currencywatcher.datasupplier.service;

import com.example.currencywatcher.datasupplier.web.domain.CoinLoreResponse;
import com.example.currencywatcher.persistence.cryptocurrency.CryptocurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DefaultDatabaseUpdateService implements DatabaseUpdateService {

    @Autowired
    CryptocurrencyRepository repository;

    @Override
    public void updateDatabase(List<CoinLoreResponse> dataForUpdate) {

        var mapToUpdateEntity = dataForUpdate.stream()
                .filter(entity -> entity.id() != null)
                .collect(Collectors.toMap(CoinLoreResponse::id, CoinLoreResponse::price_usd));
        var entitiesToUpdate = repository.findAllById(mapToUpdateEntity.keySet());

        entitiesToUpdate.stream()
                .peek(entity -> entity.setPriceUsd(mapToUpdateEntity.get(entity.getId())))
                .forEach(entity -> repository.save(entity));

        log.debug("Database updated");
    }
}
