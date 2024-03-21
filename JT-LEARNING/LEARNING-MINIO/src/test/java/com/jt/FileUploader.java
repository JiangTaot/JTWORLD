package com.jt;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("http://localhost:9002")
                            .credentials("UdI0yBktbrLUlA99kofG", "cucIaU0rWhY5X2bKAFpJkScpVWKfabv8PxzQkjhU")
                            .build();

            // Make 'asiatrip' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("jt.img").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("jt.img").build());
            } else {
                System.out.println("Bucket 'jt.img' already exists.");
            }

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            // 'asiatrip'.
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("jt.img")
                            .object("img1.jpg")
                            .filename("C:\\Users\\JiangTao\\Pictures\\img1.jpg")
                            .build());
            System.out.println(
                    "'C:\\Users\\JiangTao\\Pictures\\img1.jpg' is successfully uploaded as "
                            + "object 'img1.jpg' to bucket 'jt.img'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
}