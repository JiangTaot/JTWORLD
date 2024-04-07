package com.jt.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jt.admin.entity.JtAdminRoleRelation;
import com.jt.admin.entity.JtResource;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务类
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
public interface JtAdminRoleRelationService extends IService<JtAdminRoleRelation> {

    List<JtResource> getResourceList(Long adminId);
}
