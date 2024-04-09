package com.jt.admin.controller;

import com.jt.common.resp.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Api(tags = "测试接口")
public class TestController {
    @GetMapping("/admin/hello")
    @ApiOperation(value = "admin测试接口")
    public BaseResult<String> adminHello(){
        return BaseResult.success("hello");
    }

    @GetMapping("/test/hello")
    @ApiOperation(value = "test测试接口")
    public BaseResult<String> testHello(){
        return BaseResult.success("hello");
    }
    @GetMapping("/order/hello")
    @ApiOperation(value = "order测试接口")
    public BaseResult<String> orderHello(){
        return BaseResult.success("hello");
    }

    @GetMapping("/hi/hello")
    @ApiOperation(value = "hi测试接口")
    public BaseResult<String> hiHello(){
        return BaseResult.success("hello");
    }
}
