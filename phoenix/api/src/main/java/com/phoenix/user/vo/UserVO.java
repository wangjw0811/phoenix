package com.phoenix.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jims Wang
 * @date 2019-06-08 21:48
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = -4101104245512106019L;
    private Long id;
    private String userName;
    private String email;
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
}
