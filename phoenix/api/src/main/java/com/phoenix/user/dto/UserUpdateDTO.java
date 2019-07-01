package com.phoenix.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jims Wang
 * @date 2019-06-29 18:49
 */
@Data
public class UserUpdateDTO implements Serializable {
    private static final long serialVersionUID = -6567995326790289779L;
    @NotNull(message = "用户id不能为空")
    private Long id;
    @NotBlank(message = "用户名称不能为空")
    private String userName;
    @Email(message = "邮件地址格式有误")
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;
}
