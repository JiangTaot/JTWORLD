package com.jt.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.admin.entity.JtAdminRoleRelation;
import com.jt.admin.entity.JtResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Mapper
public interface JtAdminRoleRelationMapper extends BaseMapper<JtAdminRoleRelation> {

    List<JtResource> selectResourceList(Long adminId);
}
