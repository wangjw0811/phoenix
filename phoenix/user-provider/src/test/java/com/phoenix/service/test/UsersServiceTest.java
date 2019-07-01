package com.phoenix.service.test;

import com.phoenix.service.IUserService;
import com.phoenix.user.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jims Wang
 * @date 2019-06-29 08:53
 */
@SpringBootTest
@EnableDubbo
@RunWith(SpringRunner.class)
public class UsersServiceTest{

    @Reference(version = "1.0.0")
    private IUserService userService;

    @Test
    public void testGetUser(){
        UserVO vo = userService.getUser("Jims");
        System.out.println(vo);
    }


}
