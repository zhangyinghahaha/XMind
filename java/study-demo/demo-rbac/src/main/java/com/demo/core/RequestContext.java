package com.demo.core;

import com.demo.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestContext {
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static User getCurrentUser() {
        return (User) getCurrentRequest().getSession().getAttribute("user");
    }
}
