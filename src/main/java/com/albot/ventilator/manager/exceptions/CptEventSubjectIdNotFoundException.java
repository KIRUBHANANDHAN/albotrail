package com.albot.ventilator.manager.exceptions;

public class CptEventSubjectIdNotFoundException extends RuntimeException {
    public CptEventSubjectIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
