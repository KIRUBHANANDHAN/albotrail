package com.albot.contentorchestrationservice.controller;


import com.albot.contentorchestrationservice.dto.CareGivers;
import com.albot.contentorchestrationservice.dto.Response;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCareGiversService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCareGiversServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For CareGivers.")
@RequestMapping( "/v1/content-orchestration/caregivers")
@RestController
public class ContentOrchestrationCareGiversController {

    private ContentOrchestrationCareGiversService careGiversService;

    @Autowired
    public void ContentOrchestrationCareGiversController(ContentOrchestrationCareGiversServiceImp careGiversService) {
        this.careGiversService = careGiversService;
    }

    //Retrieving CareGivers information by given cgid
    @GetMapping("/details")
    @ApiOperation("Retrieve A CareGivers By cgid.")
    public ResponseEntity<Response> getCareGiversInfo(@RequestParam("cgid") Integer cgid) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                        .setStatusCode(HttpStatus.OK.value())
                        .setMessage("Successfully retrieving a careGivers information by given cgid")
                        .setData(careGiversService.getCareGiversByCgId(cgid)));
    }

    //Retrieving CareGivers information based on cgid
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of CareGivers Information.")
    public ResponseEntity<Response> getAllCareGiversInfo() {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the careGivers information")
                .setData(careGiversService.getAllCareGivers()));
    }

    //Creating  CareGivers information
    @PostMapping("/save")
    @ApiOperation("Created  A CareGivers Information.")
    public ResponseEntity<Response> createCareGiversInfo(@RequestBody CareGivers careGivers){
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
        return ResponseEntity.ok(new Response().setStatus("Success")
                        .setStatusCode(HttpStatus.OK.value())
                        .setMessage("Successfully updated a caregivers information")
                        .setData(careGiversService.updateCareGivers(careGivers)));
    }

    //Deleting  CareGivers information by cgid
    @DeleteMapping("/delete")
    @ApiOperation("Delete A CareGivers Information.")
    public ResponseEntity<Response> deleteCareGiversInfo(@RequestParam("cgid") Integer cgid) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                                .setStatusCode(HttpStatus.OK.value())
                                .setMessage(careGiversService.deleteCareGiversByCgId(cgid)));
    }
}

