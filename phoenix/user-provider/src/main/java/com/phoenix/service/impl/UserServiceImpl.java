package com.phoenix.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phoenix.user.dto.UserDTO;
import com.phoenix.user.dto.UserPageDTO;
import com.phoenix.user.dto.UserSaveDTO;
import com.phoenix.user.dto.UserUpdateDTO;
import com.phoenix.entity.User;
import com.phoenix.mapper.UserMapper;
import com.phoenix.service.IUserService;
import com.phoenix.utils.MD5Util;
import com.phoenix.user.vo.UserPageVO;
import com.phoenix.user.vo.UserVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jims Wang
 * @date 2019-06-08 21:34
 */
@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl implements IUserService  {
    @Autowired
    private UserMapper userMapper;
    public Long saveUser(UserSaveDTO userDTO) {
        User user = new User();
        userDTO.setPassword(MD5Util.getMD5(userDTO.getPassword()));
        BeanUtils.copyProperties(userDTO,user);
        // 自定义插入方法，返回自动生成主键
        boolean flag = userMapper.saveUser(user);
        Long id = user.getId();
        if(flag){
            System.out.println(id);
            return id;
        }
        return 0L;
    }

    public String deleteUserById(Long id) {
        boolean flag = this.removeById(id);
        if(flag){
            return String.format("id为%s的用户删除成功",id);
        }else{
            return String.format("id为%s的用户删除失败",id);
        }
    }

    @Override
    public String updateUserById(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        boolean flag = this.updateById(user);
        if(flag){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    public UserVO getUser(String userName) {
        Wrapper<User> wrapper = new QueryWrapper();
        ((QueryWrapper<User>) wrapper).eq("user_name",userName);
        User user = (User)this.getOne(wrapper);
        if(user == null){
            return null;
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user,vo);
        return vo;
    }

    public List<UserVO> getUsers(UserDTO userDTO) {
        Wrapper<User> wrapper = new QueryWrapper<>();
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        ((QueryWrapper<User>) wrapper).setEntity(user);
        List<User> users = this.list(wrapper);
        return bo2Vo(users);
    }

    @Override
    public UserPageVO getPageUsers(UserPageDTO userPageDTO) {
        IPage page = new Page(userPageDTO.getCurrent(),userPageDTO.getSize());
        Wrapper<User> wrapper = new QueryWrapper<>();
        User user = new User();
        BeanUtils.copyProperties(userPageDTO,user);
        ((QueryWrapper<User>) wrapper).setEntity(user);
        IPage p = this.page(page, wrapper);
        List<User> users = p.getRecords();
        // 将结果转换成VO返回
        List<UserVO> userVos = bo2Vo(users);
        UserPageVO userPageVO = new UserPageVO();
        userPageVO.setTotal(p.getTotal());
        userPageVO.setCurrent(p.getCurrent());
        userPageVO.setSize(p.getSize());
        userPageVO.setRecords(userVos);
        return userPageVO;
    }

    // 将结果转换成VO返回
    private List<UserVO> bo2Vo(List<User> users) {
        List<UserVO> userVos = new ArrayList<>();
        if(users != null && users.size() > 0){
            for(User u : users){
                UserVO vo = new UserVO();
                BeanUtils.copyProperties(u,vo);
                userVos.add(vo);
            }
        }
        return userVos;
    }
}
