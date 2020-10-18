package com.albot.contentorchestrationservice.exception;

public class FailedToSendOneTimePassword extends RuntimeException {
    public FailedToSendOneTimePassword(String message) {
        super("Error:" + message);
    }
}
