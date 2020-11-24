package com.albot.ventilator.manager.exceptions;

public class CallOutHadmIdNotFoundException extends RuntimeException {
    public CallOutHadmIdNotFoundException(String message) {
        super("Error:" + message);
    }
}

