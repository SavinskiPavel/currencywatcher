package com.example.currencywatcher.management.api.client.web;

import com.example.currencywatcher.management.api.client.service.ClientService;
import com.example.currencywatcher.management.api.client.web.domain.ClientNotificationRequest;
import com.example.currencywatcher.management.api.client.web.resource.ClientOutResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<ClientOutResource> getAll() {

        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientOutResource notify(@RequestBody ClientNotificationRequest request) {

        return service.notify(request.username(), request.symbol().toUpperCase());
    }
}
