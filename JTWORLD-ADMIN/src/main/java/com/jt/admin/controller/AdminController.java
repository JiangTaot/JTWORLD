package com.jt.admin.controller;

import com.jt.admin.dto.AdminDto;
import com.jt.admin.dto.LoginDto;
import com.jt.admin.entity.JtAdmin;
import com.jt.admin.service.JtAdminService;
import com.jt.admin.vo.LoginVo;
import com.jt.common.resp.BasePage;
import com.jt.common.resp.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
@Api(tags = "管理员接口")
public class AdminController {
    private final JtAdminService adminService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public BaseResult<LoginVo> login(@Validated @RequestBody LoginDto loginDto) throws AuthenticationException {
        return BaseResult.success(adminService.login(loginDto.getUsername(), loginDto.getPassword()));
    }

    @ApiOperation("获取管理员列表")
    @PostMapping("/list")
    public BaseResult<BasePage<JtAdmin>> list(@Validated @RequestBody AdminDto adminDto){
        return BaseResult.success(BasePage.restPage(adminService.getList(adminDto)));
    }
}
