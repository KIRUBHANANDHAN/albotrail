package com.albot.contentorchestrationservice.exception;

public class CurrentProceduralTerminologyRowIdNotFoundException extends RuntimeException {
    public CurrentProceduralTerminologyRowIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
