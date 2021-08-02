package com.demo.controller;

import com.demo.core.JwtUtil;
import com.demo.entity.User;
import com.demo.service.HelloService;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ying.zhang01
 */
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        if (loginUser != null) {
            log.debug("Login User: [{}]", loginUser);
            int userId = loginUser.getUserId();
            return JwtUtil.generate(String.valueOf(userId));
        }
        return "登录失败";
    }

//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        Authentication token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return "登录成功!";
//    }
//
//    @GetMapping("/logout")
//    public String logout() {
//        SecurityContextHolder.clearContext();
//        return "退出成功";
//    }
}
