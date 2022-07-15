package com.example.currencywatcher.management.api.client.service;

import com.example.currencywatcher.management.api.client.exception.UsernameIsNotUniqueException;
import com.example.currencywatcher.management.api.client.web.constructor.ClientEntityConstructor;
import com.example.currencywatcher.management.api.client.web.constructor.ClientOutResourceConstructor;
import com.example.currencywatcher.management.api.client.web.resource.ClientOutResource;
import com.example.currencywatcher.management.api.cryptocurrency.exception.CryptocurrencyEntityNotFound;
import com.example.currencywatcher.persistence.cryptocurrency.CryptocurrencyRepository;
import com.example.currencywatcher.persistence.client.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DefaultClientService implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;
    @Autowired
    private ClientOutResourceConstructor clientOutResourceConstructor;
    @Autowired
    private ClientEntityConstructor clientEntityConstructor;
    @Autowired
    private ClientNotificationService clientNotificationService;

    @Override
    public ClientOutResource notify(String username, String symbol) {

        var cryptocurrencyFromDb = cryptocurrencyRepository
                .findBySymbol(symbol).orElseThrow(() -> new CryptocurrencyEntityNotFound(symbol));

        if (clientRepository.existsByUsername(username)) {
            throw new UsernameIsNotUniqueException(username);
        }

        var customerToSave = clientEntityConstructor.construct(username, cryptocurrencyFromDb);

        var savedClient = clientRepository.save(customerToSave);
        log.info("Client saved in db: {}", customerToSave);

        clientNotificationService.getNotifications(savedClient);

        return clientOutResourceConstructor.construct(savedClient);
    }

    @Override
    public List<ClientOutResource> findAll() {

        return clientRepository.findAll().stream()
                .map(entity -> clientOutResourceConstructor.construct(entity))
                .collect(Collectors.toList());
    }
}
