package com.jt.controller;

import com.jt.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public Object upload(MultipartFile file, String bucketName) throws IOException {
        return fileService.upload(file.getInputStream(), bucketName, file.getOriginalFilename());
    }

    @PostMapping("/download")
    public String download(String filePath, String bucketName) {
        return fileService.download(filePath, bucketName);
    }

    @PostMapping("/presigned")
    public String presigned(String filePath, String bucketName) {
        return fileService.presigned(filePath, bucketName);
    }

}
