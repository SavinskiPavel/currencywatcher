package com.example.currencywatcher.datasupplier.config;

import com.example.currencywatcher.httpclient.config.HttpClientConfig;
import com.example.currencywatcher.persistence.config.PersistenceConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import static com.fasterxml.jackson.core.JsonParser.Feature.AUTO_CLOSE_SOURCE;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Configuration
@Import({HttpClientConfig.class, PersistenceConfig.class})
@EnableScheduling
public class MainConfig {

    @Bean
    public ObjectMapper objectMapper() {

        var objectMapper = new ObjectMapper();
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(AUTO_CLOSE_SOURCE, true);
        return objectMapper;
    }
}
