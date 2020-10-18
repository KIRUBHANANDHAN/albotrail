package com.albot.contentorchestrationservice.exception;

public class UserCredentialNotFound extends RuntimeException{
    public UserCredentialNotFound(String message) {
        super("Error:" +message);
    }
}
