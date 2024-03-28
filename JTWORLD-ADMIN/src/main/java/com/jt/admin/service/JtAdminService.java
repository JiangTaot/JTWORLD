package com.jt.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jt.admin.entity.JtAdmin;
import com.jt.admin.vo.LoginVo;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
public interface JtAdminService extends IService<JtAdmin> {

    LoginVo login(String username, String password);

    JtAdmin getAdminById(Long adminId);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     */
    JtAdmin getAdminByUsername(String username);
}
