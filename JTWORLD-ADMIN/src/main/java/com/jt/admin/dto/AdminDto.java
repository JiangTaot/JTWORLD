package com.jt.admin.dto;

import com.jt.common.req.BaseReq;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "管理员查询参数")
public class AdminDto extends BaseReq {

}
