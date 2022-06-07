package com.demo.controller;

import com.demo.annotation.NotResponseBody;
import com.demo.service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@RestController
public class HomeController {
    private ResourceService resourceService;

    public HomeController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/index")
    public Set<String> getIndex() {
        return resourceService.getCurrentUserMenus();
    }

    @GetMapping("hello")
    @NotResponseBody
    public String hello() {
        //int i = 10/0;
        return "Hello, World!";
    }
}
