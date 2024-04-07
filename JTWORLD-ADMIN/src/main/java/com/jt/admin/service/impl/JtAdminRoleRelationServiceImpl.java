package com.jt.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jt.admin.entity.JtAdminRoleRelation;
import com.jt.admin.entity.JtResource;
import com.jt.admin.mapper.JtAdminRoleRelationMapper;
import com.jt.admin.service.JtAdminRoleRelationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Service
public class JtAdminRoleRelationServiceImpl extends ServiceImpl<JtAdminRoleRelationMapper, JtAdminRoleRelation> implements JtAdminRoleRelationService {

    @Override
    public List<JtResource> getResourceList(Long adminId) {
        return this.baseMapper.selectResourceList(adminId);
    }
}
