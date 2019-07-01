package com.phoenix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phoenix.entity.User;

/**
 * @author Jims Wang
 * @date 2019-06-08 21:32
 */
public interface UserMapper extends BaseMapper<User> {

    boolean saveUser(User user);

}
