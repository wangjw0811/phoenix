package com.phoenix.service;

import com.phoenix.user.dto.UserPageDTO;
import com.phoenix.user.dto.UserDTO;
import com.phoenix.user.dto.UserSaveDTO;
import com.phoenix.user.dto.UserUpdateDTO;
import com.phoenix.user.vo.UserPageVO;
import com.phoenix.user.vo.UserVO;

import java.util.List;

/**
 * @author Jims Wang
 * @date 2019-06-08 21:25
 */
public interface IUserService{

    /**
     * 创建用户据信息
     * @param user
     * @return
     */
    Long saveUser(UserSaveDTO user);

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    String deleteUserById(Long id);

    /**
     * 根据id修改用户信息
     * @param userUpdateDTO
     * @return
     */
    String updateUserById(UserUpdateDTO userUpdateDTO);

    /**
     * 根据用户名查找用户信息
     * @param userName
     * @return
     */
    UserVO getUser(String userName);

    /**
     * 查询所有用户信息
     * @param userDTO
     * @return
     */
    List<UserVO> getUsers(UserDTO userDTO);

    /**
     * 分页查询用户信息
     * @param userPageDTO
     * @return
     */
    UserPageVO getPageUsers(UserPageDTO userPageDTO);


}
