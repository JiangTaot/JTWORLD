package com.jt.admin.config;

import com.jt.admin.service.JtAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class AdminSecurityConfig {
    private JtAdminService adminService;

    @Autowired
    public void setAdminService(JtAdminService adminService) {
        this.adminService = adminService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> adminService.loadUserByUsername(username);
    }

}
