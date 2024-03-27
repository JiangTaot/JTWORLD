package com.jt.admin.controller;

import com.jt.common.resp.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class TestController {
    @GetMapping("/hello")
    public BaseResult<String> hello(){
        return BaseResult.success("hello");
    }
}
