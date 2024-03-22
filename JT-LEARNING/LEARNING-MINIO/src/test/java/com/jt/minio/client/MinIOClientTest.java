package com.jt.minio.client;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import lombok.SneakyThrows;

public class MinIOClientTest {

    @SneakyThrows
    public static void main(String[] args) {
        // MinioClient 客户端构建方式
        MinioClient minioClient = MinioClient.builder().endpoint("http://127.0.0.1:9002").credentials("UdI0yBktbrLUlA99kofG", "cucIaU0rWhY5X2bKAFpJkScpVWKfabv8PxzQkjhU").build();
        System.out.println(minioClient);

        // MinioBucket 桶操作
        boolean exist = minioClient.bucketExists(BucketExistsArgs.builder().bucket("test01").build());
        System.out.println(exist);

        if (exist == false) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("test01").build());
            System.out.println("创建桶" + "test01");
        }

        // 桶集合
        minioClient.listBuckets().forEach(bucket -> System.out.println("桶：" + bucket.name()));

        // 删除桶
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket("test01").build());
    }
}
