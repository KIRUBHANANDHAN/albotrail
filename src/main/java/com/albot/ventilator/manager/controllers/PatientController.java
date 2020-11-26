package com.albot.ventilator.manager.controllers;

import com.albot.ventilator.manager.model.web.Patients;
import com.albot.ventilator.manager.model.web.Response;
import com.albot.ventilator.manager.service.PatientService;
import com.albot.ventilator.manager.service.impl.PatientServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "Patients", description = "Content Orchestration Operations For Patient.", tags = { "Patients" })
@RequestMapping("/v1/api/patients")
@RestController
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    private PatientService patientService;

    @Autowired
    public void ContentOrchestrationPatientController(PatientServiceImp patientService) {
        this.patientService = patientService;
    }

    //Retrieving Patient information give by patientId
    @GetMapping("/details")
    @ApiOperation("Retrieve An Patient Information By patientId.")
    public ResponseEntity<Response> getPatientInfo(@RequestParam("patientId") Integer patientId) {
        logger.info("Fetching patient information based on filter : patientId = {}", patientId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving patient information by given patientId")
                .setData(patientService.getByPatientId(patientId)));
    }

    //Retrieving a Patients information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of Patients information.")
    public ResponseEntity<Response> getAllPatientsInfo() {
        logger.info("Fetching list of patient information");
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the patients information")
                .setData(patientService.getAllPatients()));

    }

    //Creating a Patients information
    @PostMapping("/save")
    @ApiOperation("Create A Patient Information.")
    public ResponseEntity<Response> createPatientInfo(@RequestBody Patients patients) {
        logger.info("Saving patient information : {} ", patients);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Successfully created a patient information")
                .setData(patientService.createPatients(patients)));
    }

    //Updating  Patients information
    @PutMapping("/update")
    @ApiOperation("Update A Patient Information.")
    public ResponseEntity<Response> updatePatientInfo(@RequestBody Patients patients) {
        logger.info("Updating patient information : {} ", patients);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated patient information")
                .setData(patientService.updatePatients(patients)));
    }

    //Deleting  Patient information by given patientId
    @DeleteMapping("/delete")
    @ApiOperation("Delete A Patient Information By patientId.")
    public ResponseEntity<Response> deletePatientInfo(@RequestParam("patientId") Integer patientId) {
        logger.info("Deleting patient information based on filter : patientId = {} ", patientId);
        patientService.deletePatientByPatientId(patientId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted patient information given by patientId"));
    }
}
