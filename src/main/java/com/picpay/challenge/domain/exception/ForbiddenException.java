package com.picpay.challenge.domain.exception;

public class ForbiddenException extends RuntimeException {

    private Integer statusCode;
    private String message;

    public ForbiddenException(Integer statusCode, String message) {
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
