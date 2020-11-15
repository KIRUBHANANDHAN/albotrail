package com.albot.ventilator.manager.controllers;

import com.albot.ventilator.manager.model.web.Response;
import com.albot.ventilator.manager.model.web.UserDemoGraphicsRegistration;
import com.albot.ventilator.manager.service.UserDemoGraphicsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "ContentOrchestrations", description = "Content Orchestration Operations For UserDemoGraphicsController.")
@RequestMapping("/v1/api/user")
@RestController
public class UserDemoGraphicsController {

    private static final Logger logger = LoggerFactory.getLogger(UserDemoGraphicsController.class);

    private final UserDemoGraphicsService userDemoGraphicsService;

    @Autowired
    public UserDemoGraphicsController(UserDemoGraphicsService userDemoGraphicsService) {
        this.userDemoGraphicsService = userDemoGraphicsService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Response> getUserDemoGraphics(@PathVariable("username") String username) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a user information by username")
                .setData(userDemoGraphicsService.getByUserName(username)));
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createDemoGraphics(@RequestBody UserDemoGraphicsRegistration userDemoGraphicsRegistration) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully created a user information")
                .setData(userDemoGraphicsService.saveUserDemoGraphicsRegistration(userDemoGraphicsRegistration)));
    }
}
