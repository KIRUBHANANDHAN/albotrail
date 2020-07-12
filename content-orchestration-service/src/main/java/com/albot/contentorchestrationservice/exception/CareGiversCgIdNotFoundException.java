package com.albot.contentorchestrationservice.exception;

public class CareGiversCgIdNotFoundException extends RuntimeException{
    public CareGiversCgIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
