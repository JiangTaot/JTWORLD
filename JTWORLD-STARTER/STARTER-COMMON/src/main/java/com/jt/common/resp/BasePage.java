package com.jt.common.resp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 通用分页数据封装类
 * Created by macro on 2019/4/19.
 */
@Getter
@Setter
public class BasePage<T> {
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> BasePage<T> restPage(List<T> list) {
        BasePage<T> result = new BasePage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> BasePage<T> restPage(Page<T> pageInfo) {
        BasePage<T> result = new BasePage<T>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

    /**
     * 分页入参
     */
    public static void paramPage(int pageNum, int pageSize, Boolean isAll) {
        if (isAll) {
            PageHelper.clearPage();
        } else {
            PageHelper.startPage(pageNum, pageSize);
        }
    }

    public static void paramPage(int pageNum, int pageSize) {
        paramPage(pageNum, pageSize, Boolean.FALSE);
    }
}
