package com.demo.interceptor;

import com.demo.core.JwtUtil;
import com.demo.core.UserContext;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zhangying
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/login".equals(request.getRequestURI())) {
            return true;
        }
        Claims claims = JwtUtil.parse(request.getHeader("Authorization"));
        if (claims != null) {
            UserContext.add(claims.getSubject());
            return true;
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 设置响应内容，结束请求
        out.write("Interceptor请先登录");
        out.flush();
        out.close();
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
    }
}
