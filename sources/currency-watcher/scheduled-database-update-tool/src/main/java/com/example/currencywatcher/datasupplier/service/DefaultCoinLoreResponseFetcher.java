package com.example.currencywatcher.datasupplier.service;

import com.example.currencywatcher.datasupplier.exception.JsonParsingException;
import com.example.currencywatcher.datasupplier.exception.ScheduledDatabaseUpdateToolException;
import com.example.currencywatcher.datasupplier.web.domain.CoinLoreResponse;
import com.example.currencywatcher.httpclient.AppHttpClient;
import com.example.currencywatcher.httpclient.constructor.AppHttpRequestConstructor;
import com.example.currencywatcher.httpclient.domain.AppHttpRequest;
import com.example.currencywatcher.httpclient.domain.AppHttpResponse;
import com.example.currencywatcher.httpclient.exception.HttpRequestException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.currencywatcher.httpclient.domain.HttpMethod.GET;

@Service
@Slf4j
public class DefaultCoinLoreResponseFetcher implements CoinLoreResponseFetcher {

    @Autowired
    private AppHttpClient httpClient;
    @Autowired
    private AppHttpRequestConstructor appHttpRequestConstructor;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public CoinLoreResponse fetch(String url) {

        log.debug("Attempt to fetch response");

        var appHttpRequest = appHttpRequestConstructor.construct(GET, url, null);
        var appHttpResponse = executeRequest(appHttpRequest);
        var body = appHttpResponse.body();

        if (body == null || body.isBlank() || appHttpResponse.status() != 200) {
            throw new ScheduledDatabaseUpdateToolException("Bad response from datasource server");
        }

        try {
            var coinLoreResponses = objectMapper.readValue(body, new TypeReference<List<CoinLoreResponse>>() {
            });
            return coinLoreResponses.stream()
                    .findFirst().orElse(null);
        } catch (Exception ex) {
            throw new JsonParsingException("Unable to parse json from response from datasource server", ex);
        }
    }

    private AppHttpResponse executeRequest(AppHttpRequest request) {

        try {
            return httpClient.send(request);
        } catch (HttpRequestException ex) {
            throw new ScheduledDatabaseUpdateToolException("Error during processing request", ex);
        }
    }
}
