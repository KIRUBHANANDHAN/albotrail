package com.albot.contentorchestrationservice.exception;

import com.albot.contentorchestrationservice.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdmissionsHadmIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(AdmissionsHadmIdNotFoundException ex) {
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(BadStatusRequestException.class)
    public ResponseEntity<Response> exceptionHandler(BadStatusRequestException ex) {
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(CallOutHadmIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(CallOutHadmIdNotFoundException ex) {
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(CareGiversCgIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(CareGiversCgIdNotFoundException ex) {
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }

    @ExceptionHandler(PatientSubjectIdNotFoundException.class)
    public ResponseEntity<Response> exceptionHandler(PatientSubjectIdNotFoundException ex) {
        return ResponseEntity.ok(new Response().setStatus("Failed")
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()));
    }
}
