package com.demo.service;

import com.demo.core.RequestContext;
import com.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void doSomething() {
        User user = RequestContext.getCurrentUser();
        System.out.println("[Service 当前登录用户]: " + user);
    }
}
