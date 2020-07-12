package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.CallOut;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCallOutService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCallOutServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Api(value = "contentOrchestrations", description = "Content orchestration operations for CallOut.")
@RequestMapping( "/v1/content-orchestration/callout")
@RestController
public class ContentOrchestrationCallOutController {

    private ContentOrchestrationCallOutService callOutService;

    @Autowired
    public void ContentOrchestrationAdmissionsController(ContentOrchestrationCallOutServiceImp callOutService) {
        this.callOutService = callOutService;
    }

    //Retrieving CallOut information by hadmId
    @GetMapping("/details")
    @ApiOperation("Retrieve an CallOut by hadmId.")
    public ResponseEntity<EntityModel<CallOut>> getCallOut(@RequestParam("hadmId") Integer handId) {
        return  ResponseEntity.ok(
                EntityModel.of(callOutService.getCallOut(handId)));
    }

    //Retrieving all CallOut information
    @GetMapping
    @ApiOperation("Retrieve a list of all CallOut.")
    public ResponseEntity<CollectionModel<EntityModel<CallOut>>> getAllCallOut() {
        return null;
    }

    //Creating a CallOut information
    @PostMapping("/save")
    @ApiOperation("Add an CallOut CallOut.")
    public ResponseEntity<EntityModel<CallOut>> createCallOut(@RequestBody CallOut callOut){
        return ResponseEntity.ok(
                EntityModel.of(callOutService.createCallOut(callOut)));
    }

    //Updating  CallOut information
    @PutMapping("/update")
    @ApiOperation("Update an CallOut information.")
    public ResponseEntity<EntityModel<CallOut>> updateCallOut(@RequestBody CallOut callOut) {
        return ResponseEntity.ok(
                EntityModel.of(callOutService.updateCallOut(callOut)));
    }

    //Deleting  CallOut information
    @DeleteMapping("/{handId}")
    @ApiOperation("Delete an Admissions information.")
    public ResponseEntity<EntityModel<CallOut>> deleteCallOut(UUID handId) {
        return null;
    }
}
