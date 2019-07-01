package com.phoenix.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Jims Wang
 * @date 2019-06-08 21:27
 */
@Data
public class UserSaveDTO implements Serializable {
    private static final long serialVersionUID = -8622845159600273133L;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @Email(message = "邮件地址格式有误")
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;

}
