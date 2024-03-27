package com.jt.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jt.admin.entity.JtAdmin;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
public interface JtAdminService extends IService<JtAdmin> {

    String getAdminName();

}
