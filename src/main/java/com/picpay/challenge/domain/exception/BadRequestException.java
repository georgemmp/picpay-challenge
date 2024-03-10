package com.picpay.challenge.domain.exception;

public class BadRequestException extends RuntimeException {

    private Integer statusCode;
    private String message;

    public BadRequestException(Integer statusCode, String message) {
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
