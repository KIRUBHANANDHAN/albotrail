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
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Api(value = "UserDemoGraphics", description = "Content Orchestration Operations For UserDemoGraphicsController.",tags = { "UserDemoGraphics" })
@RequestMapping("/v1/api/user")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserDemoGraphicsService userDemoGraphicsService;

    @Autowired
    public UserController(UserDemoGraphicsService userDemoGraphicsService) {
        this.userDemoGraphicsService = userDemoGraphicsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUserDemoGraphics(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully retrieving a user information by username")
                .setData(userDemoGraphicsService.getById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createDemoGraphics(@RequestBody UserDemoGraphicsRegistration userDemoGraphicsRegistration) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully created a user information")
                .setData(userDemoGraphicsService.saveUserDemoGraphicsRegistration(userDemoGraphicsRegistration)));
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateUserDemoGraphics(@RequestBody UserDemoGraphicsRegistration userDemoGraphicsRegistration) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully update a user information")
                .setData(userDemoGraphicsService.updateUserDemoGraphicsRegistration(userDemoGraphicsRegistration)));
    }

    @PostMapping(value = "/profile/{id}")
    public ResponseEntity<Response> userProfileImage(@RequestParam("imageFile") MultipartFile multipartFile, @PathVariable("id") Long id) {
        return ResponseEntity.ok(new Response().setStatus("Success")
                .setStatusCode(HttpStatus.OK.value())
                .setMessage("Successfully uploaded a user profile image")
                .setData(userDemoGraphicsService.uploadUserProfileImage(multipartFile)));
    }
}
