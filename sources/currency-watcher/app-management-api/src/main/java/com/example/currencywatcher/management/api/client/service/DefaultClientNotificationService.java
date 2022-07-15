package com.example.currencywatcher.management.api.client.service;

import com.example.currencywatcher.persistence.client.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Service
public class DefaultClientNotificationService implements ClientNotificationService {

    private static final int INITIAL_DELAY = 0;
    private static final int DELAY = 20000; //20 seconds

    ScheduledExecutorService scheduledExecutorService;
    @Autowired
    private DatabaseObserver observer;

    @Override
    public void getNotifications(ClientEntity clientEntity) {

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, clientEntity.getUsername()));
        scheduledExecutorService.scheduleWithFixedDelay(() -> observer.handleUpdatedDb(clientEntity),
                INITIAL_DELAY, DELAY, MILLISECONDS);
    }
}
