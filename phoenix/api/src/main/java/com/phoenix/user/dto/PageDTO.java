package com.phoenix.user.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author Jims Wang
 * @date 2019-06-29 16:29
 */
@Data
public class PageDTO<T> {
    /**
     * 结果集
     */
    private List<T> records;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 当前页数量
     */
    private long size;
    /**
     * 当前页码
     */
    private long current;
    /**
     * 升序查找字段集
     */
    private String[] ascs;
    /**
     * 降序查找字段集
     */
    private String[] descs;

    public PageDTO() {
        this.records = Collections.emptyList();
        this.total = 0L;
        this.size = 10L;
        this.current = 1L;
    }
}
