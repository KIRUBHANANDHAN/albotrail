package com.albot.contentorchestrationservice.exception;

public class BadStatusRequestException extends RuntimeException {
    public BadStatusRequestException(String message) {
        super("Bad status request: " + message);
    }
}
