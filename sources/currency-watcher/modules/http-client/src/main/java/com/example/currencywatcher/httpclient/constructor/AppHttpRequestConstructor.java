package com.example.currencywatcher.httpclient.constructor;

import com.example.currencywatcher.httpclient.domain.AppHttpRequest;
import com.example.currencywatcher.httpclient.domain.HttpMethod;

public class AppHttpRequestConstructor {

    public AppHttpRequest construct(HttpMethod httpMethod, String url, String body) {

        return AppHttpRequest.builder()
                .method(httpMethod)
                .url(url)
                .body(body)
                .build();
    }
}
