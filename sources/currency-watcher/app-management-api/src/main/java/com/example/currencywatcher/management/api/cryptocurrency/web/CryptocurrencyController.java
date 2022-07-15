package com.example.currencywatcher.management.api.cryptocurrency.web;

import com.example.currencywatcher.management.api.cryptocurrency.service.CryptocurrencyService;
import com.example.currencywatcher.management.api.cryptocurrency.web.resource.CryptocurrencyOutResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrencies")
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyService service;

    @GetMapping
    public List<CryptocurrencyOutResource> getAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public CryptocurrencyOutResource getOne(@PathVariable String id) {

        return service.findById(id);
    }
}
