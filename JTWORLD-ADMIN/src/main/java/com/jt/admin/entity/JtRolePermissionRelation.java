package com.jt.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 后台用户角色和权限关系表
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Getter
@Setter
@TableName("jt_role_permission_relation")
public class JtRolePermissionRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long roleId;

    private Long permissionId;


}
