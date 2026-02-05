package com.athar.aiassistant.dto;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private boolean success;
    private String message;
    private Object errors;
    private LocalDateTime timestamp;

    public ApiErrorResponse(String message, Object errors) {
        this.success = false;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    // getters & setters
}