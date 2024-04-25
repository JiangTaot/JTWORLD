package com.jt.策略_函数式.controller;

import com.jt.策略_函数式.service.ISeasonService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SeasonController {

    @Resource
    private ISeasonService seasonService;
    @PostMapping("/season/{type}")
    public String getSeason(@PathVariable("type") String type) {
        return seasonService.getSeason(type);
    }
}
