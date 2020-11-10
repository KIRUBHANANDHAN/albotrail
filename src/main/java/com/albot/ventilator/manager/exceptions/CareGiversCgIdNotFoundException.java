package com.albot.ventilator.manager.exceptions;

public class CareGiversCgIdNotFoundException extends RuntimeException {
    public CareGiversCgIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
