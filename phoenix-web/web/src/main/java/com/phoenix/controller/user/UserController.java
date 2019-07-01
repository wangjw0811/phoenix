package com.phoenix.controller.user;

import com.phoenix.user.dto.UserDTO;
import com.phoenix.user.dto.UserPageDTO;
import com.phoenix.user.dto.UserSaveDTO;
import com.phoenix.user.dto.UserUpdateDTO;
import com.phoenix.service.IUserService;
import com.phoenix.utils.ResultRsp;
import com.phoenix.user.vo.UserPageVO;
import com.phoenix.user.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jims Wang
 * @date 2019-06-27 21:30
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0",check = false)
    private IUserService userService;

    @PostMapping("/saveUser")
    @ApiOperation("创建用户信息")
    public ResultRsp<Long> saveUser(@Validated @RequestBody UserSaveDTO userSaveDTO){
        Long result = userService.saveUser(userSaveDTO);
        return ResultRsp.success(result);
    }

    @DeleteMapping("deleteUserById")
    @ApiOperation("根据id删除用户信息")
    public ResultRsp<String> deleteUserById(@RequestParam Long id){
        String result = userService.deleteUserById(id);
        return ResultRsp.success(result);
    }

    @PutMapping("updateUserById")
    @ApiOperation("根据id修改用户信息")
    public ResultRsp<String> updateUserById(@Validated @RequestBody UserUpdateDTO userUpdateDTO){
        String result = userService.updateUserById(userUpdateDTO);
        return ResultRsp.success(result);
    }

    @GetMapping("/getUser")
    @ApiOperation("根据用户名称查询用户信息")
    public ResultRsp<UserVO> getUser(@RequestParam(value = "userName") String userName){
        UserVO user = userService.getUser(userName);
        return ResultRsp.success(user);
    }

    @PostMapping("/getUsers")
    @ApiOperation("查询所有用户信息")
    public ResultRsp<List<UserVO>> getUsers(@RequestBody UserDTO userDTO){
        List<UserVO> users = userService.getUsers(userDTO);
        return ResultRsp.success(users);
    }

    @PostMapping("/getPageUsers")
    @ApiOperation("分页查询用户信息")
    public ResultRsp<UserPageVO> getPageUsers(@RequestBody UserPageDTO userPageDTO){
        UserPageVO userPageVO = userService.getPageUsers(userPageDTO);
        return ResultRsp.success(userPageVO);
    }

}
