package io.albot.ventilator.manager.controllers;


import io.albot.ventilator.manager.service.DocumentManagementService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
@Api(value = "Profile Pic", description = "Albot Ventilator Operation  uploading and retrieving profile image", tags = {"Profile Pic"})
@RequestMapping("/v1/api/profile/image")
@RestController
public class ProfileImageUploaderController {
    @Value("${aws-s3-details.bucket}")
    String bucket;
    @Autowired
    private DocumentManagementService docService;


    @PostMapping
    public String uploadFile(@RequestParam("pic") MultipartFile mfile, @RequestParam("id") String id) throws IOException, URISyntaxException {

        File file = docService.convertMultiPartFileToFile(mfile);

        mfile.transferTo(file);


        return docService.uploadFileToS3bucket(mfile.getOriginalFilename(), file, bucket, id);


    }

    @GetMapping
    public String uploadFile(@RequestParam("filename") String filename) {


        return docService.getS3Link(filename, bucket);


    }
}
