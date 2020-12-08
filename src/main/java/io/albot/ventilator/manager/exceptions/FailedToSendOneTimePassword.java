package io.albot.ventilator.manager.exceptions;

public class FailedToSendOneTimePassword extends RuntimeException {
    public FailedToSendOneTimePassword(String message) {
        super("Error:" + message);
    }
}
