package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ying.zhang01
 */
@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/data/v1/users")
    public List<User> getUsers(
            @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10")int pageSize
    ) {
        return userService.getAllUserForPage(pageNum, pageSize);
    }

    @GetMapping("/data/v1/users/{userId}")
    public User getUserOne(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/data/v1/users")
    public int createUser(@RequestBody User user) {
        userService.insertUser(user);
        return user.getUserId();
    }

    @PutMapping("/data/v1/users/{userId}")
    public int updateUser(@PathVariable int userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.updateUser(user);
    }

    @DeleteMapping("/data/v1/users/{userId}")
    public int deleteUser(@PathVariable int userId) {
        return userService.deleteUserById(userId);
    }
}
