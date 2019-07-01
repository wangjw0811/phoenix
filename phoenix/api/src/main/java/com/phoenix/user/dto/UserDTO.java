package com.phoenix.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jims Wang
 * @date 2019-06-08 21:47
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -5351729067181894947L;
    private Long id;
    private String userName;
    private String email;
}
