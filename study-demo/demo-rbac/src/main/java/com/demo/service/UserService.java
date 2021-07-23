package com.demo.service;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ying.zhang01
 */
@Service
public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("用户名不存在!");
        }
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("密码不正确!");
        }

        return user;
    }

    public User queryUserById(int userId) {
        return userMapper.selectUserByUserId(userId);
    }
}
