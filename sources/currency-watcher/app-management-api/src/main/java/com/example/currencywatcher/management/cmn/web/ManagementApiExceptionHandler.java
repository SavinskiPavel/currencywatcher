package com.example.currencywatcher.management.cmn.web;

import com.example.currencywatcher.management.cmn.exception.ManagementApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ManagementApiExceptionHandler {

    @ExceptionHandler(ManagementApiException.class)
    ResponseEntity<ErrorOutResource> handleManagementException(ManagementApiException ex) {

        log.error("Error during processing request", ex);

        return new ResponseEntity<>(
                new ErrorOutResource(ex.getMessage()),
                HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorOutResource> handleUnexpectedException(Exception ex) {

        log.error("Unexpected exception during request execution", ex);

        return new ResponseEntity<>(
                new ErrorOutResource("Internal server error"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
