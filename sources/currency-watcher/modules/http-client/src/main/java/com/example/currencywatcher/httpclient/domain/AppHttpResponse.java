package com.example.currencywatcher.httpclient.domain;

import lombok.Builder;

import javax.annotation.Nullable;

public record AppHttpResponse(
        int status,
        @Nullable String body
) {
    @Builder
    public AppHttpResponse {
    }
}
