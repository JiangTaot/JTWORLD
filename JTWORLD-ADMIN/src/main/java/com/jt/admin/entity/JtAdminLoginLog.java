package com.jt.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 后台用户登录日志表
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Getter
@Setter
@TableName("jt_admin_login_log")
public class JtAdminLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long adminId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String ip;

    private String address;

    /**
     * 浏览器登录类型
     */
    private String userAgent;


}
