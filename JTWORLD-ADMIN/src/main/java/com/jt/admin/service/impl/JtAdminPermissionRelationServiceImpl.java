package com.jt.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jt.admin.entity.JtAdminPermissionRelation;
import com.jt.admin.mapper.JtAdminPermissionRelationMapper;
import com.jt.admin.service.JtAdminPermissionRelationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Service
public class JtAdminPermissionRelationServiceImpl extends ServiceImpl<JtAdminPermissionRelationMapper, JtAdminPermissionRelation> implements JtAdminPermissionRelationService {

}
