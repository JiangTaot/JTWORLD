package com.jt.admin.service.impl;

import com.jt.admin.entity.JtAdmin;
import com.jt.admin.entity.JtResource;
import com.jt.admin.service.JTAdminCacheService;
import com.jt.admin.service.JtAdminService;
import com.jt.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JTAdminCacheServiceImpl implements JTAdminCacheService {
    private JtAdminService adminService;
    private RedisService redisService;
    @Value("${pre-redis.database}")
    private String REDIS_DATABASE;
    @Value("${pre-redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${pre-redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Value("${pre-redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Autowired
    public void setAdminService(JtAdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void delAdmin(Long adminId) {
        JtAdmin admin = adminService.getAdminById(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public JtAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (JtAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(JtAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<JtResource> getResouceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<JtResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<JtResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }


}
