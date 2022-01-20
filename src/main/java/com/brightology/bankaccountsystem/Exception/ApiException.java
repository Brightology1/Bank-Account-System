package com.brightology.bankaccountsystem.Exception;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final String details;
    private final ZonedDateTime timestamp;

    public ApiException(String message, String details, ZonedDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}