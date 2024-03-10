package com.picpay.challenge.domain.exception;

public class NotFoundException extends RuntimeException {

    private Integer statusCode;
    private String message;

    public NotFoundException(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
