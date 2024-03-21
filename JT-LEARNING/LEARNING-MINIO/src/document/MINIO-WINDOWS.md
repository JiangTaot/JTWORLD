# MINIO-WINDOWS

> 文件存储服务
>
> 官网首页：https://min.io/
>
> WINDOWS 版本下载地址：https://dl.min.io/server/minio/release/windows-amd64/minio.exe

## 快速入门

### 安装

### 环境配置

### 启动

~~~bash
# minio.exe server [目录] --console-address :[管理端端口号] --address :[访问端端口号]
.\minio.exe server C:\minio --console-address :9001 --address :9002
~~~

### windows 注册为服务

> 利用 winsw 将 minio 注册为服务
>
> winsw下载地址：https://github.com/winsw/winsw/releases

1、将 `WinSW-x64.exe` 放在 `minio.exe`同级目录下，更名为 `minio-server.exe`

2、添加配置文件`minio-server.xml`

~~~xml
<service>
   <id>minio-server</id>
   <name>minio-server</name>
   <description>minio文件存储服务器</description>
   <env name="MINIO_HOME" value="%BASE%"/><!--系统环境变量配置-->
   <executable>%BASE%\minio.exe</executable><!--执行的exe-->
   <arguments>server "%BASE%" --console-address :9001 --address :9002</arguments><!--执行参数-->
   <logpath>%BASE%\logs</logpath><!--日志配置-->
   <log mode="roll-by-size-time">
       <sizeThreshold>10240</sizeThreshold>
       <pattern>yyyyMMdd</pattern>
       <autoRollAtTime>00:00:00</autoRollAtTime>
       <zipOlderThanNumDays>5</zipOlderThanNumDays>
   </log>
</service>
~~~

3、启动服务

~~~bash
minio-server.exe install  # 注册服务
计算机管理 -> 服务和应用程序 -> minio-server  启动  # windows 启动服务
minio-server.exe uninstall # 注销服务
~~~

4、管理端访问地址

http://localhost:9001/

## MINIO 客户端（可选）

> 下载地址：https://dl.min.io/client/mc/release/windows-amd64/mc.exe

### 连接MINIO服务器

~~~bash
mc.exe alias set local http://127.0.0.1:9000 minioadmin minioadmin
mc.exe admin info local
~~~

## JAVA 集成 MINIO

### 管理端生成密钥

~~~json
{"url":"http://localhost:9001/api/v1/service-account-credentials","accessKey":"UdI0yBktbrLUlA99kofG","secretKey":"cucIaU0rWhY5X2bKAFpJkScpVWKfabv8PxzQkjhU","api":"s3v4","path":"auto"}
~~~

### 上传文件示例

~~~java
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
~~~

