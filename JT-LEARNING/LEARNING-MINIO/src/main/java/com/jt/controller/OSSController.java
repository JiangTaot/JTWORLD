package com.jt.controller;

import com.jt.template.MinioTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class OSSController {

    private final MinioTemplate minioTemplate;
    @Autowired
    public OSSController(MinioTemplate minioTemplate) {
        this.minioTemplate = minioTemplate;
    }

    @PostMapping("/upload")
    public Object upload(MultipartFile file, String bucketName) throws IOException {
        return minioTemplate.putObject(file.getInputStream(), bucketName, file.getOriginalFilename());
    }
}
