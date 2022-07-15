package com.example.currencywatcher.datasupplier;

import com.example.currencywatcher.datasupplier.service.ScheduledDatabaseUpdateExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {

        var context = SpringApplication.run(Application.class, args);
        var executor = context.getBean(ScheduledDatabaseUpdateExecutor.class);
        executor.startDatabaseUpdateProcess();
    }
}
