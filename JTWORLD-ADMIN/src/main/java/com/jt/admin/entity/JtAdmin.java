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
 * 后台用户表
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Getter
@Setter
@TableName("jt_admin")
public class JtAdmin implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String username;

  private String password;

  /**
   * 头像
   */
  private String icon;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 昵称
   */
  private String nickName;

  /**
   * 备注信息
   */
  private String note;

  /**
   * 创建时间
   */
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;

  /**
   * 最后登录时间
   */
  private LocalDateTime loginTime;

  /**
   * 帐号启用状态：0->禁用；1->启用
   */
  private Integer status;


}
