package com.jt.common.config;

import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public abstract class SwaggerConfiguration {
    @Value("${knife4j.title}")
    private String title;
    @Value("${knife4j.description}")
    private String description;
    @Value("${knife4j.author.name}")
    private String author;
    @Value("${knife4j.author.url}")
    private String authorUrl;
    @Value("${knife4j.author.email}")
    private String authorEmail;
    @Value("${knife4j.serviceUrl}")
    private String serviceUrl;
    @Value("${knife4j.version}")
    private String version;
    @Value("${knife4j.basePackage}")
    private String basePackage;
    @Value("${knife4j.enable}")
    private boolean enable;

    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 主页
                .apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description(description)// 简介
                        .contact(new Contact(author, authorUrl, authorEmail))
                        .termsOfServiceUrl(serviceUrl)// 服务器url
                        .version(version)// 版本
                        .build())
                // 分组名称
                .groupName("手机商城")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build().enable(enable);
    }
}