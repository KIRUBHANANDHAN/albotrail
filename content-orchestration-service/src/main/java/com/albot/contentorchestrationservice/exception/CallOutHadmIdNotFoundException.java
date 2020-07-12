package com.albot.contentorchestrationservice.exception;

public class CallOutHadmIdNotFoundException extends RuntimeException {
    public CallOutHadmIdNotFoundException(String message) {
        super("Error:" +message);
    }
}

