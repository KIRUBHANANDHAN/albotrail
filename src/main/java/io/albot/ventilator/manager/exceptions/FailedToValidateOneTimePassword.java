package io.albot.ventilator.manager.exceptions;

public class FailedToValidateOneTimePassword extends RuntimeException {
    public FailedToValidateOneTimePassword(String message) {
        super("Error:" + message);
    }
}
