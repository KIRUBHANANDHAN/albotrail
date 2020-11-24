package com.albot.ventilator.manager.exceptions;

public class CurrentProceduralTerminologyRowIdNotFoundException extends RuntimeException {
    public CurrentProceduralTerminologyRowIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
