package com.jt.admin.config;

import com.jt.admin.entity.JtResource;
import com.jt.admin.service.JtAdminService;
import com.jt.admin.service.JtResourceService;
import com.jt.secure.service.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class AdminSecurityConfig {
    private JtAdminService adminService;
    private JtResourceService resourceService;

    @Autowired
    @Lazy
    public void setAdminService(JtAdminService adminService) {
        this.adminService = adminService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> adminService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
            List<JtResource> resourceList = resourceService.list();
            for (JtResource resource : resourceList) {
                map.put(resource.getUrl(), new SecurityConfig(resource.getId() + ":" + resource.getName()));
            }
            return map;
        };
    }

    @Autowired
    @Lazy
    public void setResourceService(JtResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
