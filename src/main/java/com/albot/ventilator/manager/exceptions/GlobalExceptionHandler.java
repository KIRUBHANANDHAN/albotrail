package com.albot.ventilator.manager.exceptions;

import com.albot.ventilator.manager.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AdmissionsHadmIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(AdmissionsHadmIdNotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(BadStatusRequestException.class)
    public ResponseEntity<Response> exceptionHandler(BadStatusRequestException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(CallOutHadmIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(CallOutHadmIdNotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(CareGiversCgIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(CareGiversCgIdNotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(PatientSubjectIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(PatientSubjectIdNotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(CptEventSubjectIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(CptEventSubjectIdNotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(CurrentProceduralTerminologyRowIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(CurrentProceduralTerminologyRowIdNotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }
}
