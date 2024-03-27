package com.jt.admin.controller;

import com.jt.admin.service.JtAdminService;
import com.jt.common.resp.BaseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
@AllArgsConstructor
public class AdminController {
    private final JtAdminService adminService;

    @GetMapping("/queryAdminName")
    public BaseResult<String> queryAdminName() {
        return BaseResult.success(adminService.getAdminName());
    }
}
