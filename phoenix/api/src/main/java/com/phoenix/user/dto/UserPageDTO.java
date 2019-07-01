package com.phoenix.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jims Wang
 * @date 2019-06-29 16:25
 */
@Data
public class UserPageDTO extends PageDTO implements Serializable {
    private static final long serialVersionUID = -331718371784209368L;
    private Long id;
    private String userName;
    private String email;
}
