/*
package com.albot.ventilator.manager.controllers;


import com.albot.ventilator.manager.model.web.CareGivers;
import com.albot.ventilator.manager.model.web.Response;
import com.albot.ventilator.manager.service.CareGiversService;
import com.albot.ventilator.manager.service.impl.CareGiversServiceImp;
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
@Api(value = "CareGivers", description = "Content Orchestration Operations For CareGivers.", tags = { "CareGivers" })
@RequestMapping("/v1/api/caregivers")
@RestController
public class CareGiversController {

    private static final Logger logger = LoggerFactory.getLogger(CareGiversController.class);

    private CareGiversService careGiversService;

    @Autowired
    public void ContentOrchestrationCareGiversController(CareGiversServiceImp careGiversService) {
        this.careGiversService = careGiversService;
    }

    //Retrieving CareGivers information by given cgid
    @GetMapping("/details")
    @ApiOperation("Retrieve A CareGivers By cgid.")
    public ResponseEntity<Response> getCareGiversInfo(@RequestParam("cgid") Integer cgid) {
        logger.info("Fetching careGivers information based on filter : cgid = {} ", cgid);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a careGivers information by given cgid")
                .setData(careGiversService.getCareGiversByCgId(cgid)));
    }

    //Retrieving CareGivers information based on cgid
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of CareGivers Information.")
    public ResponseEntity<Response> getAllCareGiversInfo() {
        logger.info("Fetching list of careGivers information");
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the careGivers information")
                .setData(careGiversService.getAllCareGivers()));
    }

    //Creating  CareGivers information
    @PostMapping("/save")
    @ApiOperation("Created  A CareGivers Information.")
    public ResponseEntity<Response> createCareGiversInfo(@RequestBody CareGivers careGivers) {
        logger.info("Saving careGivers information : {} ", careGivers);
        return ResponseEntity.ok(
                new Response().setStatus("Success")
                        .setStatusCode(HttpStatus.CREATED.value())
                        .setMessage("Successfully created a caregivers information")
                        .setData(careGiversService.createCareGivers(careGivers)));
    }

    //Updating  CareGivers information based on cgid
    @PutMapping("/update")
    @ApiOperation("Update A CareGivers Information.")
    public ResponseEntity<Response> updateCareGiversInfo(@RequestBody CareGivers careGivers) {
        logger.info("Updating careGivers information : {}", careGivers);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated a caregivers information")
                .setData(careGiversService.updateCareGivers(careGivers)));
    }

    //Deleting  CareGivers information by cgid
    @DeleteMapping("/delete")
    @ApiOperation("Delete A CareGivers Information.")
    public ResponseEntity<Response> deleteCareGiversInfo(@RequestParam("cgid") Integer cgid) {
        logger.info("Saving careGivers information based on filter : cgid = {} ", cgid);
        careGiversService.deleteCareGiversByCgId(cgid);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted CareGivers information given by cgid"));
    }
}

*/
