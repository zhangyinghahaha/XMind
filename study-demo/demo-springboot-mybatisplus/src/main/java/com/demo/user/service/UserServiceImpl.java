package com.demo.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.user.entity.User;
import com.demo.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author ying.zhang01
 * @date 2022/5/27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
