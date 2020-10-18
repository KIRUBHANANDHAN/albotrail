package com.albot.contentorchestrationservice.exception;

public class InvalidUserCredentials extends RuntimeException {
    public InvalidUserCredentials(String message) {
        super("Error:" +message);
    }
}
