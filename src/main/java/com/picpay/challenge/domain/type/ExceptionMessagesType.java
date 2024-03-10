package com.picpay.challenge.domain.type;

public enum ExceptionMessagesType {

    SHOPKEEPER_CAN_NOT_PAY("Shopkeeper can not pay"),
    PIN_CODE_LENGTH("Pin code must to have 4 characters"),
    USER_NOT_FOUND("User not found"),
    INVALID_TOKEN("Invalid token"),
    INVALID_CREDENTIALS("User or password invalid"),
    API_CONSUMER_EXCEPTION("Error when consuming service"),
    TRANSFER_NOT_AUTHORIZED("Transfer not authorized"),
    NOTIFICATION_ERROR("Notification not sent"),
    USER_ALREADY_EXISTS_EMAIL("User already exists with this email"),
    USER_ALREADY_EXISTS_CPF("User already exists with this CPF or CNPJ"),
    NO_BALANCE("User has not balance");

    private String message;

    ExceptionMessagesType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String createMessage(Object... args) {
        return String.format(message, args);
    }
}
