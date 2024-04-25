package com.jt.策略_工厂.controller;

import com.jt.策略_工厂.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BaseController {

    @Resource
    private UserServiceImpl userService;
    @PostMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id){
        return userService.getUser(id);
    }
}
