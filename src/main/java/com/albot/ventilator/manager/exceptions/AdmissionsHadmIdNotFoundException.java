package com.albot.ventilator.manager.exceptions;

public class AdmissionsHadmIdNotFoundException extends RuntimeException {

    public AdmissionsHadmIdNotFoundException(String message) {
        super("Error:" + message);
    }
}
