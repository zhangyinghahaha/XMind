package com.demo.filter;

import com.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// @Component
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 简单的白名单
        if ("/login".equals(httpServletRequest.getRequestURI())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 已登录放行
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 没有登录，直接拦截请求，返回异常响应
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("Filter: 请先登录");
        out.flush();
        out.close();
    }
}
