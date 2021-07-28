package com.demo.interceptor;

import com.demo.core.JwtUtil;
import com.demo.core.UserContext;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zhangying
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/login".equals(request.getRequestURI())) {
            return true;
        }

        String token = request.getHeader("Authorization");
        token = token.replace("Bearer", "").trim();
        Claims claims = JwtUtil.parse(token);
        if (claims != null) {
            User user = userMapper.selectUserByUserId(Integer.valueOf(claims.getSubject()));

            if (user != null) {
                log.info("Current User: {}", user);
                UserContext.add(user);
                return true;
            }
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 设置响应内容，结束请求
        out.write("Interceptor请先登录");
        out.flush();
        out.close();

        log.warn("为授权访问, IP");
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
    }
}
