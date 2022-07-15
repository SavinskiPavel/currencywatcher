package com.example.currencywatcher.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.currencywatcher.persistence")
@EnableJpaRepositories("com.example.currencywatcher.persistence")
public class PersistenceConfig {
}
