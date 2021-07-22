package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

// @RestController
public class SessionController {

    private HelloService helloService;

    public SessionController(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping("login")
    public String login(@RequestBody User user, HttpSession session) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "登录成功";
        }

        return "登录失败";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "退出成功";
    }

    @GetMapping("hello")
    public String hello(HttpSession session) {
        helloService.doSomething();
        return "hello, zhang ying";
    }

    @GetMapping("hello2")
    public String hello() {
        return "hello, zhang ying";
    }
}
