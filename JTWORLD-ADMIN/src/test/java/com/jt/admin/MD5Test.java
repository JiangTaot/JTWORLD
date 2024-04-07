package com.jt.admin;

import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MD5Test {

    @Value("${secure.salt}")
    private String salt;

    /**
     * 加盐加密
     */
    @Test
    public void md5Encrypt() {
        String password = SecureUtil.md5("123123");
        System.out.println("加密后: " + password);

        String passwordEncrypt = SecureUtil.md5(password + salt);
        System.out.println("盐: " + salt);
        System.out.println("加盐加密后: " + passwordEncrypt);
    }
}
