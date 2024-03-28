package com.jt.admin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode
public class LoginDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
