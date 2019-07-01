package com.phoenix.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.*;

import java.util.Date;

/**
 * @author Jims Wang
 * @date 2019-06-21 20:50
 */
@Data
@Builder
@NoArgsConstructor
//注意全参构造器的访问级别，不要破坏Builder的规则
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private static final long serialVersionUID = -8622845159600273133L;
    private Long id;
    private String userName;
    private String email;
    private String password;
    @TableLogic
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
}
