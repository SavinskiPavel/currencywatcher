package com.example.currencywatcher.httpclient;

import com.example.currencywatcher.httpclient.domain.AppHttpRequest;
import com.example.currencywatcher.httpclient.domain.AppHttpResponse;
import com.example.currencywatcher.httpclient.domain.HttpMethod;
import com.example.currencywatcher.httpclient.exception.HttpRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JavaAppHttpClient implements AppHttpClient {

    private static final List<HttpMethod> ALLOW_REQUEST_BODY_HTTP_METHODS = List.of(HttpMethod.POST, HttpMethod.PUT);
    private final HttpClient client;

    @Override
    public AppHttpResponse send(AppHttpRequest appHttpRequest) {

        var request = constructHttpRequest(appHttpRequest);

        try {

            log.debug("Sending request: {}", request);

            var httpResponse = client.send(request, BodyHandlers.ofString());

            log.debug("Http response received: {}", httpResponse);

            return AppHttpResponse.builder()
                    .status(httpResponse.statusCode())
                    .body(httpResponse.body())
                    .build();

        } catch (Exception ex) {
            log.error("Error during request execution: {}", appHttpRequest);
            throw new HttpRequestException(ex.getMessage(), appHttpRequest, ex);
        }
    }

    private HttpRequest constructHttpRequest(AppHttpRequest appHttpRequest) {

        HttpRequest.BodyPublisher bodyPublisher;

        var method = appHttpRequest.method();
        var url = appHttpRequest.url();
        var body = appHttpRequest.url();

        if (ALLOW_REQUEST_BODY_HTTP_METHODS.contains(method) && body != null && !body.isBlank()) {
            bodyPublisher = HttpRequest.BodyPublishers.ofString(body);
        } else {
            bodyPublisher = HttpRequest.BodyPublishers.noBody();
        }

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(appHttpRequest.method().toString(), bodyPublisher)
                .build();
    }
}
