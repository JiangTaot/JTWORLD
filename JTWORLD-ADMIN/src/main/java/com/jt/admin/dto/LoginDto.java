package com.jt.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode
@ApiModel(value = "登录参数")
public class LoginDto {

    @NotBlank
    @ApiModelProperty(value = "用户名")
    private String username;
    @NotBlank
    @ApiModelProperty(value = "密码")
    private String password;
}
