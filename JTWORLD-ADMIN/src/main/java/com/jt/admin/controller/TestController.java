package com.jt.admin.controller;

import com.jt.common.resp.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Api(tags = "测试接口")
public class TestController {
    @GetMapping("/hello")
    @ApiOperation(value = "测试接口")
    public BaseResult<String> hello(){
        return BaseResult.success("hello");
    }
}
