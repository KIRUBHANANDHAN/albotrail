package io.albot.ventilator.manager.exceptions;

public class PatientSubjectIdNotFoundException extends RuntimeException {
    public PatientSubjectIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
