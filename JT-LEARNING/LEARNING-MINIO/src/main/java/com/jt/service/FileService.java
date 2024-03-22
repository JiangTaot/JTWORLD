package com.jt.service;

import java.io.InputStream;

public interface FileService {

    Object upload(InputStream inputStream, String bucketName, String originalFilename);

    String download(String fileName, String bucketName);

    String presigned(String filePath, String bucketName);
}
