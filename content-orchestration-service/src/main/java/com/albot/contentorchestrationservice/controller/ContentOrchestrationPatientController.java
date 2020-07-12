package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.CallOut;
import com.albot.contentorchestrationservice.dto.Patients;
import com.albot.contentorchestrationservice.service.ContentOrchestrationPatientService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationPatientServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Api(value = "contentOrchestrations", description = "Content orchestration operations for CareGivers.")
@RequestMapping( "/v1/content-orchestration/patients")
@RestController
public class ContentOrchestrationPatientController {

    private ContentOrchestrationPatientService  patientService;

    @Autowired
    public void ContentOrchestrationPatientController(ContentOrchestrationPatientServiceImp patientService) {
        this.patientService = patientService;
    }

    //Retrieving Patient information
    @GetMapping("/details")
    @ApiOperation("Retrieve an Patient information by subjectId.")
    public ResponseEntity<EntityModel<Patients>> getPatient(@RequestParam("subjectId") Integer subjectId) {
        return  ResponseEntity.ok(
                EntityModel.of(patientService.getBySubjectId(subjectId)));
    }

    //Retrieving Patients information
    @GetMapping
    @ApiOperation("Retrieve a list of all Patients.")
    public ResponseEntity<CollectionModel<EntityModel<Patients>>> getAllPatients() {
        return null;
    }

    //Creating a CareGivers
    @PostMapping("/save")
    @ApiOperation("Add an Patients Information.")
    public ResponseEntity<EntityModel<Patients>> createPatients(@RequestBody Patients patients){
        return ResponseEntity.ok(
                EntityModel.of(patientService.createPatients(patients)));
    }

    //Updating  Patients information
    @PutMapping("/update")
    @ApiOperation("Update an patients information.")
    public ResponseEntity<EntityModel<Patients>> updateCareGivers(@RequestBody Patients patients) {
        return ResponseEntity.ok(
                EntityModel.of(patientService.updatePatients(patients)));
    }

    //Deleting  Patients information
    @DeleteMapping("/{handId}")
    @ApiOperation("Delete an Patients information.")
    public ResponseEntity<EntityModel<CallOut>> deletePatients(UUID handId) {
        return null;
    }
}
