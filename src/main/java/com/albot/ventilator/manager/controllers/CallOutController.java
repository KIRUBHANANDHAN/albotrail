package com.albot.ventilator.manager.controllers;

import com.albot.ventilator.manager.model.CallOut;
import com.albot.ventilator.manager.model.Response;
import com.albot.ventilator.manager.service.CallOutService;
import com.albot.ventilator.manager.service.impl.CallOutServiceImp;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For CallOut.")
@RequestMapping("/v1/api/callout")
@RestController
public class CallOutController {

    private static final Logger logger = LoggerFactory.getLogger(CallOutController.class);

    private CallOutService callOutService;

    @Autowired
    public void ContentOrchestrationAdmissionsController(CallOutServiceImp callOutService) {
        this.callOutService = callOutService;
    }

    //Retrieving CallOut information given by hadmId
    @GetMapping("/details")
    @ApiOperation("Retrieve A CallOut Information By hadmId.")
    public ResponseEntity<Response> getCallOutInfo(@RequestParam("hadmId") Integer hadmId) {
        logger.info("Fetching CallOut information based on filter: hadmId = {} in  callOut Service", hadmId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a callOut information given by  hadmId")
                .setData(callOutService.getCallOutByhadmId(hadmId)));
    }

    //Retrieving all CallOut information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of CallOut Information.")
    public ResponseEntity<Response> getAllCallOutInfo() {
        logger.info("Fetching list of CallOut information");
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the callOut information")
                .setData(callOutService.getAllCallOut()));
    }

    //Creating a CallOut information
    @PostMapping("/save")
    @ApiOperation("Create A CallOut Information.")
    public ResponseEntity<Response> createCallOutInfo(@RequestBody CallOut callOut) {
        logger.info("Saving callOut information : {}", callOut);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Successfully created a callOut information")
                .setData(callOutService.createCallOut(callOut)));
    }

    //Updating a CallOut information
    @PutMapping("/update")
    @ApiOperation("Update A CallOut Information.")
    public ResponseEntity<Response> updateCallOutInfo(@RequestBody CallOut callOut) {
        logger.info("Updating CallOut information based on condition: {}", callOut);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated a callOut information")
                .setData(callOutService.updateCallOut(callOut)));
    }

    //Deleting a CallOut information given by hadmId
    @DeleteMapping("/delete")
    @ApiOperation("Delete A CallOut Information.")
    public ResponseEntity<Response> deleteCallOutInfo(@RequestParam("hadmId") Integer hadmId) {
        logger.info("Deleting callOut information based on filter : hadmI = {}", hadmId);
        callOutService.deleteCallOutByhadmId(hadmId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted callOut information given by hadmId"));
    }
}
