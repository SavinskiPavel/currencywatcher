package com.example.currencywatcher.datasupplier.service;

import com.example.currencywatcher.datasupplier.constructor.UrlConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ScheduledDatabaseUpdateExecutor {

    private static final long FIXED_DELAY = 60000L; // 1 min

    private final List<String> dataSourceFullUrls = new ArrayList<>();

    @Autowired
    private UrlConstructor urlConstructor;
    @Autowired
    private CoinLoreResponseFetcher responseFetcher;
    @Autowired
    private DatabaseUpdateService databaseUpdateService;

    @Scheduled(fixedDelay = FIXED_DELAY)
    public void startDatabaseUpdateProcess() {

        if (dataSourceFullUrls.isEmpty()) {
            dataSourceFullUrls.addAll(urlConstructor.constructUrl());
            log.debug("{} urls to start processing constructed)", dataSourceFullUrls.size());
        }

        var coinLoreResponses = dataSourceFullUrls.stream().sequential()
                .map(url -> responseFetcher.fetch(url))
                .collect(Collectors.toList());

        log.info("Successfully got coinLoreResponses: {}", coinLoreResponses);

        databaseUpdateService.updateDatabase(coinLoreResponses);
    }
}
