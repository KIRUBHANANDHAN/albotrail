package com.albot.contentorchestrationservice.exception;

public class AdmissionsHadmIdNotFoundException extends RuntimeException {

    public AdmissionsHadmIdNotFoundException(String message) {
        super("Error:" +message);
    }
}
