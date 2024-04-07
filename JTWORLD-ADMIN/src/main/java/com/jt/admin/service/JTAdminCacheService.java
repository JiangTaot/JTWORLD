package com.jt.admin.service;

import com.jt.admin.entity.JtAdmin;
import com.jt.admin.entity.JtResource;

import java.util.List;

/**
 * 后台用户缓存管理Service
 * Created by macro on 2020/3/13.
 */
public interface JTAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 获取缓存后台用户信息
     */
    JtAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(JtAdmin admin);

    /**
     * 缓存中获取后台用户资源
     */
    List<JtResource> getResouceList(Long adminId);

    /**
     * 设置后台用户资源
     */
    void setResourceList(Long adminId, List<JtResource> resourceList);
}
