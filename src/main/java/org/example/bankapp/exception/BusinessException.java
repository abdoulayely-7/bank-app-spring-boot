package org.example.bankapp.exception;

public class BusinessException extends RuntimeException  {
    public BusinessException(String message) {
        super(message);
    }
}
