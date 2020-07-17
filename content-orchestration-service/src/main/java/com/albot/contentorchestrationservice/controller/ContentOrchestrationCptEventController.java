package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.CptEvent;
import com.albot.contentorchestrationservice.dto.Response;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCptEventService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCptEventServiceImp;
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
@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For CareGivers.")
@RequestMapping( "/v1/content-orchestration/cptevent")
@RestController
public class ContentOrchestrationCptEventController {

    private static final Logger logger = LoggerFactory.getLogger(ContentOrchestrationCptEventController.class);

    private ContentOrchestrationCptEventService cptEventService;

    @Autowired
    public void ContentOrchestrationCptEventController(ContentOrchestrationCptEventServiceImp cptEventService) {
        this.cptEventService = cptEventService;
    }

    //Retrieving CptEvent information by given subjectId
    @GetMapping("/details")
    @ApiOperation("Retrieve A CptEvent By subjectId.")
    public ResponseEntity<Response> getCptEventInfo(@RequestParam("subjectId") Integer subjectId) {
        logger.info("Fetching CptEvent information based on filter : subjectId = {} ", subjectId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a CptEvent information by given subjectId")
                .setData(cptEventService.getCptEventBySubjectId(subjectId)));
    }

    //Retrieving CptEvent information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of CptEvent Information.")
    public ResponseEntity<Response> getAllCptEventInfo() {
        logger.info("Fetching list of CptEvent information");
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the CptEvent information")
                .setData(cptEventService.getAllCptEvent()));
    }

    //Creating  cptEvent information
    @PostMapping("/save")
    @ApiOperation("Created  A cptEvent Information.")
    public ResponseEntity<Response> createCptEventInfo(@RequestBody CptEvent cptEvent){
        logger.info("Saving cptEvent information : {} ", cptEvent);
        return ResponseEntity.ok(
                new Response().setStatus("Success")
                        .setStatusCode(HttpStatus.CREATED.value())
                        .setMessage("Successfully created a cptEvent information")
                        .setData(cptEventService.createCptEvent(cptEvent)));
    }

    //Updating  cptEvent information based on subjectId
    @PutMapping("/update")
    @ApiOperation("Update A cptEvent Information.")
    public ResponseEntity<Response> updateCptEventInfo(@RequestBody CptEvent cptEvent) {
        logger.info("Updating cptEvent information : {}", cptEvent);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated a cptEvent information")
                .setData(cptEventService.updateCptEvent(cptEvent)));
    }

    //Deleting  cptEvent information by subjectId
    @DeleteMapping("/delete")
    @ApiOperation("Delete A cptEvent Information.")
    public ResponseEntity<Response> deleteCptEventInfo(@RequestParam("subjectId") Integer subjectId) {
        logger.info("Saving cptEvent information based on filter : subjectId = {} ", subjectId);
        cptEventService.deleteCptEventBySubjectId(subjectId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted cptEvent information given by subjectId"));
    }

}
