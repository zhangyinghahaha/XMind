package com.demo.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.user.entity.User;
import com.demo.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ying.zhang01
 * @date 2022/5/27
 */
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetOne() {
        LambdaQueryWrapper<User> query = Wrappers.lambdaQuery();
        query.gt(User::getAge, 28);
        User user = userService.getOne(query, false);
        System.out.println(user);
//        userService.lambdaQuery().gt(User::getAge, 28).list().forEach(System.out::println);

    }

    @Test
    public void testUpdate() {
        Boolean isSuccess = userService.lambdaUpdate()
                .gt(User::getAge, 20)
                .likeRight(User::getName, "李")
                .set(User::getEmail, "zhangying@demo.com")
                .update();
        System.out.println(isSuccess);
    }
}