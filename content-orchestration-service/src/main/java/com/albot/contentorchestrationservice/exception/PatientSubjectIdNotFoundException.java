package com.albot.contentorchestrationservice.exception;

public class PatientSubjectIdNotFoundException extends RuntimeException {
    public PatientSubjectIdNotFoundException(String message) {
        super("Error:" +message);
    }
}
