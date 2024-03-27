package com.jt.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.admin.entity.JtAdminPermissionRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) Mapper 接口
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Mapper
public interface JtAdminPermissionRelationMapper extends BaseMapper<JtAdminPermissionRelation> {

}
