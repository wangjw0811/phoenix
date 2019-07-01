package com.phoenix.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jims Wang
 * @date 2019-06-29 16:47
 */
@Data
public class PageVO<T> implements Serializable {
    private static final long serialVersionUID = 5056519982423704409L;
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
}
