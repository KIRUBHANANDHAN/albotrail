package com.albot.ventilator.manager.exceptions;

public class BadStatusRequestException extends RuntimeException {
    public BadStatusRequestException(String message) {
        super("Bad status request: " + message);
    }
}
