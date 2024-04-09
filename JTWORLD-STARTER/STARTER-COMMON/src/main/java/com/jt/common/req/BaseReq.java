package com.jt.common.req;

import lombok.Data;

@Data
public class BaseReq {
    private int pageNum = 1;
    private int pageSize = 10;
    private Boolean isAll = Boolean.FALSE;
}
