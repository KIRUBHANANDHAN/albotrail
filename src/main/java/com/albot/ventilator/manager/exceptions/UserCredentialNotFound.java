package com.albot.ventilator.manager.exceptions;

public class UserCredentialNotFound extends RuntimeException {
    public UserCredentialNotFound(String message) {
        super("Error:" + message);
    }
}
