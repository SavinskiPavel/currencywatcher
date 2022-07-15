package com.example.currencywatcher.httpclient.config;

import com.example.currencywatcher.httpclient.AppHttpClient;
import com.example.currencywatcher.httpclient.JavaAppHttpClient;
import com.example.currencywatcher.httpclient.constructor.AppHttpRequestConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class HttpClientConfig {

    @Bean
    public HttpClient httpClient() {

        return HttpClient.newHttpClient();
    }

    @Bean
    public AppHttpClient appHttpClient(HttpClient httpClient) {

        return new JavaAppHttpClient(httpClient);
    }

    @Bean
    public AppHttpRequestConstructor appHttpRequestConstructor() {

        return new AppHttpRequestConstructor();
    }
}
