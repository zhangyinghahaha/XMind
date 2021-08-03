package com.demo.service;

import com.demo.entity.User;
import com.demo.entity.UserDetail;
import com.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ying.zhang01
 */
@Service
public class UserService implements UserDetailsService {
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private ResourceService resourceService;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder, ResourceService resourceService) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.resourceService = resourceService;
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

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUserById(int userId) {
        return userMapper.deleteUserById(userId);
    }

    public List<User> getAllUserForPage(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userMapper.selectAllUser());
    }

    public User getUserById(int userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("没有找到改用户");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 查询用户权限
        Set<SimpleGrantedAuthority> authorities = resourceService.getResourceIdsByUserId(user.getUserId())
                .stream()
                .map(String::valueOf)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        return new UserDetail(user, authorities);
    }
}
