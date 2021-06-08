package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ying.zhang01
 */
@Controller
public class HomeController {
    @RequestMapping(path = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello, Spring Security!";
    }
}
