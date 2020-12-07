/*
package com.albot.ventilator.manager.controllers;

import com.albot.ventilator.manager.model.web.CurrentProceduralTerminology;
import com.albot.ventilator.manager.model.web.Response;
import com.albot.ventilator.manager.service.CurrentProceduralTerminologyService;
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
@Api(value = "CurrentProceduralTerminology", description = "Content Orchestration Operations For CurrentProceduralTerminology(CPT).",tags = { "CurrentProceduralTerminology" })
@RequestMapping("/v1/api/cpt")
@RestController
public class CurrentProceduralTerminologyController {

    private static final Logger logger = LoggerFactory.getLogger(CurrentProceduralTerminologyController.class);

    private CurrentProceduralTerminologyService currentProceduralTerminologyService;

    @Autowired
    public void CurrentProceduralTerminologyController(CurrentProceduralTerminologyService currentProceduralTerminologyService) {
        this.currentProceduralTerminologyService = currentProceduralTerminologyService;
    }

    //Retrieving currentProceduralTerminology information give by rowId
    @GetMapping("/details")
    @ApiOperation("Retrieve An currentProceduralTerminology Information By rowId.")
    public ResponseEntity<Response> getCptInfo(@RequestParam("rowId") Integer rowId) {
        logger.info("Fetching currentProceduralTerminology information based on filter : rowId = {}", rowId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving currentProceduralTerminology information by given rowId")
                .setData(currentProceduralTerminologyService.getByRowId(rowId)));
    }

    //Retrieving a currentProceduralTerminology information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of currentProceduralTerminology information.")
    public ResponseEntity<Response> getAllCptInfo() {
        logger.info("Fetching list of currentProceduralTerminology information");
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the currentProceduralTerminology information")
                .setData(currentProceduralTerminologyService.getAllCurrentProceduralTerminology()));

    }

    //Creating a currentProceduralTerminology information
    @PostMapping("/save")
    @ApiOperation("Create A currentProceduralTerminology Information.")
    public ResponseEntity<Response> createCptInfo(@RequestBody CurrentProceduralTerminology currentProceduralTerminology) {
        logger.info("Saving currentProceduralTerminology information : {} ", currentProceduralTerminology);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Successfully created a currentProceduralTerminology information")
                .setData(currentProceduralTerminologyService.
                        createCurrentProceduralTerminology(currentProceduralTerminology)));
    }

    //Updating  currentProceduralTerminology information
    @PutMapping("/update")
    @ApiOperation("Update A currentProceduralTerminologyService Information.")
    public ResponseEntity<Response> updateCptInfo(@RequestBody CurrentProceduralTerminology currentProceduralTerminology) {
        logger.info("Updating currentProceduralTerminology information : {} ", currentProceduralTerminology);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated currentProceduralTerminology information")
                .setData(currentProceduralTerminologyService.
                        updateCurrentProceduralTerminology(currentProceduralTerminology)));
    }

    //Deleting  currentProceduralTerminology information by given rowId
    @DeleteMapping("/delete")
    @ApiOperation("Delete A currentProceduralTerminology Information By rowId .")
    public ResponseEntity<Response> deleteCptInfo(@RequestParam("rowId") Integer rowId) {
        logger.info("Deleting currentProceduralTerminology information based on filter : rowId = {} ", rowId);
        currentProceduralTerminologyService.deleteCurrentProceduralTerminologyByRowId(rowId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted currentProceduralTerminology information given by rowId"));
    }
}
*/
