package com.demo.controller;

import com.demo.annotation.Auth;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ying.zhang01
 */
@RestController
@Auth(id = 1000, name = "用户管理")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Auth(id = 1, name = "查询所有用户")
    @GetMapping("/data/v1/users")
    public List<User> getUsers(
            @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10")int pageSize
    ) {
        return userService.getAllUserForPage(pageNum, pageSize);
    }

    @GetMapping("/data/v1/users/{userId}")
    @Auth(id = 2, name = "查询单个用户")
    public User getUserOne(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/data/v1/users")
    @Auth(id = 3, name = "创建用户")
    public int createUser(@RequestBody User user) {
        userService.insertUser(user);
        return user.getUserId();
    }

    @PutMapping("/data/v1/users/{userId}")
    @Auth(id = 4, name = "更新用户")
    public int updateUser(@PathVariable int userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.updateUser(user);
    }

    @DeleteMapping("/data/v1/users/{userId}")
    @Auth(id = 5, name = "删除用户")
    public int deleteUser(@PathVariable int userId) {
        return userService.deleteUserById(userId);
    }
}
