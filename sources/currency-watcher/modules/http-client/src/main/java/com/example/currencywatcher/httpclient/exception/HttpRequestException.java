package com.example.currencywatcher.httpclient.exception;

import com.example.currencywatcher.httpclient.domain.AppHttpRequest;
import lombok.Getter;

@Getter
public class HttpRequestException extends HttpClientException {

    private final AppHttpRequest request;

    public HttpRequestException(String message, AppHttpRequest request, Throwable throwable) {

        super(message, throwable);
        this.request = request;
    }
}
