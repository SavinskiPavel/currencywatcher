package com.example.currencywatcher.management.api.cryptocurrency.service;

import com.example.currencywatcher.management.api.cryptocurrency.exception.CryptocurrencyEntityNotFound;
import com.example.currencywatcher.management.api.cryptocurrency.web.constructor.CryptocurrencyOutResourceConstructor;
import com.example.currencywatcher.management.api.cryptocurrency.web.resource.CryptocurrencyOutResource;
import com.example.currencywatcher.persistence.cryptocurrency.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCryptocurrencyService implements CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository repository;

    @Autowired
    private CryptocurrencyOutResourceConstructor constructor;

    @Override
    public CryptocurrencyOutResource findById(String id) {

        return constructor.construct(repository.findById(id)
                .orElseThrow(() -> new CryptocurrencyEntityNotFound(id)));
    }

    @Override
    public List<CryptocurrencyOutResource> findAll() {

        return repository.findAll()
                .stream()
                .map(entity -> constructor.construct(entity))
                .collect(Collectors.toList());
    }
}
