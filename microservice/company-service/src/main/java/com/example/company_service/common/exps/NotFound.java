package com.example.company_service.common.exps;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
