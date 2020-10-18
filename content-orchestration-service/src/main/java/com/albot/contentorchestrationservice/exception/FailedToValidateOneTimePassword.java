package com.albot.contentorchestrationservice.exception;

public class FailedToValidateOneTimePassword extends RuntimeException {
    public FailedToValidateOneTimePassword(String message) {
        super("Error:" + message);
    }
}
