package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.Admissions;
import com.albot.contentorchestrationservice.dto.Response;
import com.albot.contentorchestrationservice.service.ContentOrchestrationAdmissionsService;
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
@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For Admissions.")
@RequestMapping( "/v1/content-orchestration/admissions")
@RestController
public class ContentOrchestrationAdmissionsController  {

    private static final Logger logger = LoggerFactory.getLogger(ContentOrchestrationAdmissionsController.class);

    private ContentOrchestrationAdmissionsService admissionsService;

    @Autowired
    public ContentOrchestrationAdmissionsController(ContentOrchestrationAdmissionsService admissionsService) {
        this.admissionsService = admissionsService;
    }

    //Retrieving admissions information given by hadmId
    @GetMapping("/details")
    @ApiOperation("Retrieve A Admissions By hadmId.")
    public ResponseEntity<Response> getAdmissionsInfo(@RequestParam("hadmId") Integer hadmId) {
        logger.info("Fetching admissions information based on filter : handId = {} ", hadmId);
        return  ResponseEntity.ok(new Response().setStatus("Success")
                   .setStatusCode(HttpStatus.OK.value())
                   .setMessage("Successfully retrieving a admissions information given by  hadmId")
                   .setData(admissionsService.getAdmissionsByhadmId(hadmId)));
    }

    //Retrieving all admissions information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of Admissions Information.")
    public ResponseEntity<Response> getAllAdmissionsInfo() {
        logger.info("Fetching list of admissions information");
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the admissions information")
                .setData(admissionsService.getAllAdmissions()));
    }

    //Creating  admissions information
    @PostMapping("/save")
    @ApiOperation("Create A Admissions Information.")
    public ResponseEntity<Response> createAdmissionsInfo(@RequestBody Admissions admissions) {
        logger.info("Saving admissions information : {}" , admissions);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Successfully created a admissions information")
                .setData(admissionsService.createAdmissions(admissions)));
    }

    //Updating  admissions information
    @PutMapping("/update")
    @ApiOperation("Update A Admissions Information.")
    public ResponseEntity<Response> updateAdmissionsInfo(@RequestBody Admissions admissions) {
        logger.info("Updating admissions information : {}" , admissions);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated a admissions information")
                .setData(admissionsService.updateAdmissions(admissions)));
    }

    //Deleting  admissions information
    @DeleteMapping("/delete")
    @ApiOperation("Delete A Admissions Information.")
    public ResponseEntity<Response> deleteAdmissionsInfo(@RequestParam("hadmId") Integer hadmId) {
        logger.info("Deleting admissions information  based on filter : hadmid = {}" , hadmId);
        admissionsService.deleteAdmissionsByhadmId(hadmId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted admissions information given by hadmId"));
    }
}
