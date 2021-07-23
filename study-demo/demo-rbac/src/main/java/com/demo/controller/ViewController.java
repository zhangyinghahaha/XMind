package com.demo.controller;

import com.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class ViewController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Map<String, String> menuMap = new HashMap<>();
        menuMap.put("/user/account", "用户管理");
        menuMap.put("/user/role", "权限管理");
        menuMap.put("/data", "数据管理");
        request.setAttribute("menuMap", menuMap);

        Set<String> menus = resourceService.getCurrentUserMenus();
        request.setAttribute("menus", menus);
        return "index";
    }
}
