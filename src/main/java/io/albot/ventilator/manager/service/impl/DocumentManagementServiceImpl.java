
package io.albot.ventilator.manager.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import io.albot.ventilator.manager.repos.postgres.UserDemoGraphicsRepository;
import io.albot.ventilator.manager.service.DocumentManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


@Slf4j
@Service
public class DocumentManagementServiceImpl implements DocumentManagementService {

    @Autowired
    private AmazonS3 amazonS3Client;
    @Autowired
    UserDemoGraphicsRepository repo;

    @Transactional
    public String uploadFileToS3bucket(String fileName, File file, String bucketName, String id) {
        URL url = null;
        try {
            repo.updateProfileLink(fileName, Long.parseLong(id));
            amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));

        } catch (Exception e) {
            log.error("Error uploading aws file", e);
            return "failed";
        }

        return "uploaded";


    }

    public String getS3Link(String fileName, String bucketName) {
        URL url = null;
        try {
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);
            url = amazonS3Client.generatePresignedUrl(bucketName, fileName, expiration);
        } catch (Exception e) {
            log.error("Error uploading aws file", e);
            return "failed";
        }

        return url.toExternalForm();


    }

    public File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}
