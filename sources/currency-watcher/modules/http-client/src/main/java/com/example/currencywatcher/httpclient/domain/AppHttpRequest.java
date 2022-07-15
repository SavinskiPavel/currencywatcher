package com.example.currencywatcher.httpclient.domain;

import lombok.Builder;

import javax.annotation.Nullable;

public record AppHttpRequest(
        HttpMethod method,
        String url,
        @Nullable String body
) {
    @Builder
    public AppHttpRequest {
    }
}
