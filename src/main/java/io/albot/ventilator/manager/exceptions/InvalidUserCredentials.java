package io.albot.ventilator.manager.exceptions;

public class InvalidUserCredentials extends RuntimeException {
    public InvalidUserCredentials(String message) {
        super("Error:" + message);
    }
}
