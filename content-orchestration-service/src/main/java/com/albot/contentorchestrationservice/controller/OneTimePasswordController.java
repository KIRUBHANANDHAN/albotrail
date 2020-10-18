package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.model.OneTimePassword;
import com.albot.contentorchestrationservice.model.Response;
import com.albot.contentorchestrationservice.service.ContentOrchestrationOtpService;
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
@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For OneTimePasswordController(OTP).")
@RequestMapping("/v1/content-orchestration")
@RestController
public class OneTimePasswordController {

    private static final Logger logger = LoggerFactory.getLogger(OneTimePasswordController.class);

    private ContentOrchestrationOtpService contentOrchestrationOtpService;
    @Autowired
    public OneTimePasswordController(ContentOrchestrationOtpService contentOrchestrationOtpService) {
        this.contentOrchestrationOtpService = contentOrchestrationOtpService;
    }

    //get an user name from request param.
    @GetMapping("/generate/otp")
    @ApiOperation("Generate OTP for given user name.")
    public ResponseEntity<Response> getOtpInfo(@RequestParam("userName") String userName) {
        logger.info("Generate otp for given  username {}",userName);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setData(contentOrchestrationOtpService.getRandomNumber(userName)));
    }

    //Validate Given one time password.
    @PostMapping("/validate/otp")
    @ApiOperation("Validated OTP based  given user name and 4-digit number OTP.")
    public ResponseEntity<Response> validateOTP(@RequestBody OneTimePassword otp) {
        logger.info("Validate one time password for given user {}", otp.getUserName());
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully validate one time password information for given user "+ otp.getUserName())
               .setData(contentOrchestrationOtpService.validateGivenOtp(otp)));
    }
}
