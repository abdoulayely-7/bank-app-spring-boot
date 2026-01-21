package org.example.bankapp.dto;

import java.time.LocalDateTime;

public class ApiErrorResponse {
    private int status;
    private String message;
    // private Map<String, String> errors;
    private String path;
    private LocalDateTime timestamp;

    public ApiErrorResponse(int status, String message, String path) {
        this.status = status;
        this.message = message;
        // this.errors = errors;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    // public Map<String, String> getErrors() {
    // return errors;
    // }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
