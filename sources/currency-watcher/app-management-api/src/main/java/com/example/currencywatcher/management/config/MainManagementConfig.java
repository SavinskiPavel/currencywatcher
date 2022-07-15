package com.example.currencywatcher.management.config;

import com.example.currencywatcher.persistence.config.PersistenceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceConfig.class)
public class MainManagementConfig {
}
