package com.jt.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.admin.entity.JtAdmin;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author jt
 * @since 2024-03-27
 */
@Mapper
public interface JtAdminMapper extends BaseMapper<JtAdmin> {

}