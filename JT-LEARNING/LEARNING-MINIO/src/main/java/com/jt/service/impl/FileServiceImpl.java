package com.jt.service.impl;

import com.jt.core.MinioTemplate;
import com.jt.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {

    private final MinioTemplate minioTemplate;

    @Autowired
    public FileServiceImpl(MinioTemplate minioTemplate) {
        this.minioTemplate = minioTemplate;
    }

    @Override
    public Object upload(InputStream inputStream, String bucketName, String originalFilename) {
        return minioTemplate.putObject(inputStream, bucketName, originalFilename);
    }

    @Override
    public String preview(String fileName, String bucketName) {
        return minioTemplate.getPreviewUrl(fileName, bucketName);
    }
}
