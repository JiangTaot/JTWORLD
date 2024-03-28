package com.jt.admin.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginVo {

    private String username;

    private String token;
}
