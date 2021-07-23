package com.demo.controller;

import com.demo.core.JwtUtil;
import com.demo.entity.User;
import com.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ying.zhang01
 */
@RestController
public class JwtController {
    private HelloService helloService;

    public JwtController(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return JwtUtil.generate(user.getUsername());
        }
        return "JWT登录失败";
    }

    @GetMapping("hello")
    public String hello(HttpServletRequest request) {
        helloService.doSomething();
        return "hello, jwt";
    }
}
