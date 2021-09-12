package com.rcm.restaurants.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private LocalDateTime dateTime;
    private String message;
    private String description;

    public ExceptionResponse(LocalDateTime dateTime, String message, String description) {
        this.dateTime = dateTime;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
