package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.CallOut;
import com.albot.contentorchestrationservice.dto.CareGivers;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCareGiversService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCareGiversServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Api(value = "contentOrchestrations", description = "Content orchestration operations for CareGivers.")
@RequestMapping( "/v1/content-orchestration/caregivers")
@RestController
public class ContentOrchestrationCareGiversController {

    private ContentOrchestrationCareGiversService careGiversService;

    @Autowired
    public void ContentOrchestrationCareGiversController(ContentOrchestrationCareGiversServiceImp careGiversService) {
        this.careGiversService = careGiversService;
    }

    //Retrieving CareGivers information by cgid
    @GetMapping("/details")
    @ApiOperation("Retrieve an CareGivers by cgid.")
    public ResponseEntity<EntityModel<CareGivers>> getCareGivers(@RequestParam("cgid") Integer cgid) {
        return  ResponseEntity.ok(
                EntityModel.of(careGiversService.getCareGivers(cgid)));
    }

    //Retrieving CareGivers information based on cgid
    @GetMapping
    @ApiOperation("Retrieve a list of all CareGivers.")
    public ResponseEntity<CollectionModel<EntityModel<CareGivers>>> getAllCareGivers() {
        return null;
    }

    //Creating a CareGivers
    @PostMapping("/save")
    @ApiOperation("Add an CareGivers CareGivers.")
    public ResponseEntity<EntityModel<CareGivers>> createCareGivers(@RequestBody CareGivers careGivers){
        return ResponseEntity.ok(
                EntityModel.of(careGiversService.createCareGivers(careGivers)));
    }

    //Updating  CareGivers information based on cgid
    @PutMapping("/update")
    @ApiOperation("Update an CareGivers information.")
    public ResponseEntity<EntityModel<CareGivers>> updateCareGivers(@RequestBody CareGivers careGivers) {
        return ResponseEntity.ok(
                EntityModel.of(careGiversService.updateCareGivers(careGivers)));
    }

    //Deleting  CareGivers information by cgid
    @DeleteMapping("/{handId}")
    @ApiOperation("Delete an CareGivers information.")
    public ResponseEntity<EntityModel<CallOut>> deleteCareGivers(UUID cgid) {
        return null;
    }
}

