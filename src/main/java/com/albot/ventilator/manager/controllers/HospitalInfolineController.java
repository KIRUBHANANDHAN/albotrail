package com.albot.ventilator.manager.controllers;

import com.albot.ventilator.manager.model.web.Response;
import com.albot.ventilator.manager.service.HospitalInfoLineService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "HospitalInfoline", description = "Content Orchestration Operations For HospitalInfolineController.",tags = { "HospitalInfoline" })
@RequestMapping("/v1/api/hosp")
@RestController
public class HospitalInfolineController {

    private static final Logger logger = LoggerFactory.getLogger(HospitalInfolineController.class);
    @Autowired
    private HospitalInfoLineService hospitalInfoLineService;


    @GetMapping("/{hosp_id}")
    public ResponseEntity<Response> getUserDemoGraphics(@PathVariable("hosp_id") String hosp_id) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a hospital information by hosp_id")
                .setData(hospitalInfoLineService.getByHospID(hosp_id)));
    }


}
