package com.albot.contentorchestrationservice.exception;

public class CptEventSubjectIdNotFoundException extends RuntimeException {
    public CptEventSubjectIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
