package com.albot.ventilator.manager.controllers;

import com.albot.ventilator.manager.model.web.HospitalRegistration;
import com.albot.ventilator.manager.model.web.Response;
import com.albot.ventilator.manager.service.HospitalRegistrationService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "HospitalRegistration", description = "Content Orchestration Operations For HospitalRegistrationController.", tags = { "HospitalInfoline" })
@RequestMapping("/v1/api")
@RestController
public class HospitalRegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(HospitalRegistrationController.class);

    private final HospitalRegistrationService hospitalRegistrationService;

    @Autowired
    public HospitalRegistrationController(HospitalRegistrationService hospitalRegistrationService) {
        this.hospitalRegistrationService = hospitalRegistrationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> CreateHospital(@RequestBody HospitalRegistration hospitalRegistration) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully register given  hospital information.")
                .setData(hospitalRegistrationService.createHospital(hospitalRegistration)));
    }
}
