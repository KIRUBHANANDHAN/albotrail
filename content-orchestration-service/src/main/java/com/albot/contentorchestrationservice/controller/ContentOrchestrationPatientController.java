package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.Patients;
import com.albot.contentorchestrationservice.dto.Response;
import com.albot.contentorchestrationservice.service.ContentOrchestrationPatientService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationPatientServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For CareGivers.")
@RequestMapping( "/v1/content-orchestration/patients")
@RestController
public class ContentOrchestrationPatientController {

    private ContentOrchestrationPatientService  patientService;

    @Autowired
    public void ContentOrchestrationPatientController(ContentOrchestrationPatientServiceImp patientService) {
        this.patientService = patientService;
    }

    //Retrieving Patient information give by subjectId
    @GetMapping("/details")
    @ApiOperation("Retrieve An Patient Information By subjectId.")
    public ResponseEntity<Response> getPatientInfo(@RequestParam("subjectId") Integer subjectId) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving patient information by given subjectId")
                .setData(patientService.getBySubjectId(subjectId)));
    }

    //Retrieving a Patients information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of Patients information.")
    public ResponseEntity<Response> getAllPatientsInfo() {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the patients information")
                .setData(patientService.getAllPatients()));

    }

    //Creating a Patients information
    @PostMapping("/save")
    @ApiOperation("Create A Patient Information.")
    public ResponseEntity<Response> createPatientInfo(@RequestBody Patients patients) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Successfully created a patient information")
                .setData(patientService.createPatients(patients)));
    }

    //Updating  Patients information
    @PutMapping("/update")
    @ApiOperation("Update A Patient Information.")
    public ResponseEntity<Response> updatePatientInfo(@RequestBody Patients patients) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated patient information")
                .setData(patientService.updatePatients(patients)));
    }

    //Deleting  Patient information by given subjectId
    @DeleteMapping("/delete")
    @ApiOperation("Delete A Patient Information By subjectId .")
    public ResponseEntity<Response> deletePatientInfo(@RequestParam("subjectId") Integer subjectId) {
        patientService.deletePatientsBySubjectId(subjectId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted patient information given by subjectId"));
    }
}
