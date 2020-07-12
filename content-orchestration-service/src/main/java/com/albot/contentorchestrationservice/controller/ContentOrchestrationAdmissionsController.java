package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.Admissions;
import com.albot.contentorchestrationservice.service.ContentOrchestrationAdmissionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "contentOrchestrations", description = "Content orchestration operations for Admissions.")
@RequestMapping( "/v1/content-orchestration/admissions")
@RestController
public class ContentOrchestrationAdmissionsController  {

    private ContentOrchestrationAdmissionsService admissionsService;

    @Autowired
    public ContentOrchestrationAdmissionsController(ContentOrchestrationAdmissionsService admissionsService) {
        this.admissionsService = admissionsService;
    }

    //Retrieving admissions information
    @GetMapping("/details")
    @ApiOperation("Retrieve an Admissions by hadmId.")
    public ResponseEntity<EntityModel<Admissions>> getAdmissions(@RequestParam("hadmId") Integer handId) {
        return  ResponseEntity.ok(
                     EntityModel.of(admissionsService.getAdmissions(handId)));
    }

    //Retrieving all admissions information
    @GetMapping
    @ApiOperation("Retrieve a list of all Admissions.")
    public ResponseEntity<CollectionModel<EntityModel<Admissions>>> getAllAdmissions() {
        return null;
    }

    //Creating  admissions information
    @PostMapping("/save")
    @ApiOperation("Add an Admissions information.")
    public ResponseEntity<EntityModel<Admissions>> createAdmissions(@RequestBody Admissions admissions){
        return ResponseEntity.ok(
                EntityModel.of(admissionsService.createAdmissions(admissions)));
    }

    //Updating  admissions information
    @PutMapping("/update")
    @ApiOperation("Update an Admissions information.")
    public ResponseEntity<EntityModel<Admissions>> updateAdmissions(@RequestBody Admissions admissions) {
        return ResponseEntity.ok(
                EntityModel.of(admissionsService.updateAdmissions(admissions)));
    }

    //Deleting  admissions information
    @DeleteMapping("/{{handId}}")
    @ApiOperation("Delete an Admissions information.")
    public ResponseEntity<EntityModel<Admissions>> deleteAdmissions(Integer handId) {
        return null;
    }
}
