package io.albot.ventilator.manager.controllers;


import io.albot.ventilator.manager.model.web.ResetUserPassword;
import io.albot.ventilator.manager.model.web.Response;
import io.albot.ventilator.manager.service.ForGotPasswordService;
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
@Api(value = "ForGotPassword", description = "Albot Ventilator Operation  For ForGotPasswordController.", tags = { "ForGotPassword" })
@RequestMapping("/v1/api")
@RestController
public class ForGotPasswordController {

    private static final Logger logger = LoggerFactory.getLogger(ForGotPasswordController.class);

    private final ForGotPasswordService forGotPasswordService;

    @Autowired
    public ForGotPasswordController(ForGotPasswordService forGotPasswordService) {
        this.forGotPasswordService = forGotPasswordService;
    }

    //Identify by Given user Name.
    @GetMapping("/identify/user/login")
    @ApiOperation("login Identify by user based  on user name.")
    public ResponseEntity<Response> userLoginIdentify(@RequestParam("uname") String userName) {
        logger.info("For login Identify by given user {}", userName);
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieve given login identify user information " + userName)
                .setData(forGotPasswordService.getIdentifyByLoginUser(userName)));
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
