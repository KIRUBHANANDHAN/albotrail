package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.dto.CallOut;
import com.albot.contentorchestrationservice.dto.Response;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCallOutService;
import com.albot.contentorchestrationservice.service.ContentOrchestrationCallOutServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For CallOut.")
@RequestMapping( "/v1/content-orchestration/callout")
@RestController
public class ContentOrchestrationCallOutController {

    private ContentOrchestrationCallOutService callOutService;

    @Autowired
    public void ContentOrchestrationAdmissionsController(ContentOrchestrationCallOutServiceImp callOutService) {
        this.callOutService = callOutService;
    }

    //Retrieving CallOut information given by hadmId
    @GetMapping("/details")
    @ApiOperation("Retrieve A CallOut Information By hadmId.")
    public ResponseEntity<Response> getCallOutInfo(@RequestParam("hadmId") Integer hadmId) {
        return  ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a callOut information given by  hadmId")
                .setData(callOutService.getCallOutByhadmId(hadmId)));
    }

    //Retrieving all CallOut information
    @GetMapping("/all")
    @ApiOperation("Retrieve The List Of CallOut Information.")
    public ResponseEntity<Response> getAllCallOutInfo() {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving all the callOut information")
                .setData(callOutService.getAllCallOut()));
    }

    //Creating a CallOut information
    @PostMapping("/save")
    @ApiOperation("Create A CallOut Information.")
    public ResponseEntity<Response> createCallOutInfo(@RequestBody CallOut callOut){
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Successfully created a callOut information")
                .setData(callOutService.createCallOut(callOut)));
    }

    //Updating a CallOut information
    @PutMapping("/update")
    @ApiOperation("Update A CallOut Information.")
    public ResponseEntity<Response> updateCallOutInfo(@RequestBody CallOut callOut) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully updated a callOut information")
                .setData(callOutService.updateCallOut(callOut)));
    }

    //Deleting a CallOut information given by hadmId
    @DeleteMapping("/delete")
    @ApiOperation("Delete A CallOut Information.")
    public ResponseEntity<Response> deleteCallOutInfo(@RequestParam("hadmId") Integer hadmId) {
        callOutService.deleteCallOutByhadmId(hadmId);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully deleted callOut information given by hadmId"));
    }
}
