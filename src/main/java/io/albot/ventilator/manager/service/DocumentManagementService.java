package io.albot.ventilator.manager.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URISyntaxException;

public interface DocumentManagementService {
    String uploadFileToS3bucket(String fileName, File file, String bucketName, String id) throws URISyntaxException;

    File convertMultiPartFileToFile(MultipartFile file);

    String getS3Link(String fileName, String bucketName);
}
