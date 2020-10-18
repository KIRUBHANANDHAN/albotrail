package com.albot.contentorchestrationservice.controller;


import com.albot.contentorchestrationservice.model.Response;
import com.albot.contentorchestrationservice.model.IdentifyByLoginUser;
import com.albot.contentorchestrationservice.model.ResetUserPassword;;
import com.albot.contentorchestrationservice.service.ForGotPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For ForGotPasswordController.")
@RequestMapping("/v1/content-orchestration")
@RestController
public class ForGotPasswordController {

    private static final Logger logger = LoggerFactory.getLogger(ForGotPasswordController.class);

    private ForGotPasswordService forGotPasswordService;

    @Autowired
    public ForGotPasswordController(ForGotPasswordService forGotPasswordService) {
        this.forGotPasswordService = forGotPasswordService;
    }

    //Identify by Given user Name.
    @PostMapping("/identify/user/login")
    @ApiOperation("login Identify by user based  on user name.")
    public ResponseEntity<Response> userLoginIdentify(@RequestBody IdentifyByLoginUser identifyByLoginUser) {
        logger.info("For login Identify by given user {}", identifyByLoginUser.getUserName());
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieve given login identify user information " + identifyByLoginUser.getUserName())
                .setData(forGotPasswordService.getIdentifyByLoginUser(identifyByLoginUser)));
    }

    //Reset password  by Given user Name.
    @PostMapping("/reset/password")
    @ApiOperation("login Identify by user based  on user name.")
    public ResponseEntity<Response> resetUserPassword(@RequestBody ResetUserPassword forGotPassword) {
        logger.info("For login Identify by given user {}", forGotPassword.getUserName());
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully reset password for given user " + forGotPassword.getUserName())
                .setData(forGotPasswordService.resetPassword(forGotPassword)));
    }
}
