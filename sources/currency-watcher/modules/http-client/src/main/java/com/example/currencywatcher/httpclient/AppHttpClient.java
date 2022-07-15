package com.example.currencywatcher.httpclient;

import com.example.currencywatcher.httpclient.domain.AppHttpRequest;
import com.example.currencywatcher.httpclient.domain.AppHttpResponse;

public interface AppHttpClient {

    /**
     * @throws HttpClientException
     */
    AppHttpResponse send(AppHttpRequest request);
}
