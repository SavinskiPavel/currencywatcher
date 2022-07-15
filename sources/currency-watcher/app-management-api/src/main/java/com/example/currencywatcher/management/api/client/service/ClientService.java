package com.example.currencywatcher.management.api.client.service;

import com.example.currencywatcher.management.api.client.web.resource.ClientOutResource;

import java.util.List;

public interface ClientService {

    ClientOutResource notify(String username, String symbol);

    List<ClientOutResource> findAll();
}
