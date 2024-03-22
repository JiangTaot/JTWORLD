package com.jt.service;

import java.io.InputStream;

public interface FileService {

    Object upload(InputStream inputStream, String bucketName, String originalFilename);

    String preview(String fileName, String bucketName);
}
