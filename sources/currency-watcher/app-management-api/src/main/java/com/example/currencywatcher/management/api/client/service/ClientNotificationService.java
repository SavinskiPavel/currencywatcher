package com.example.currencywatcher.management.api.client.service;

import com.example.currencywatcher.persistence.client.ClientEntity;

public interface ClientNotificationService {

    void getNotifications(ClientEntity clientEntity);
}
