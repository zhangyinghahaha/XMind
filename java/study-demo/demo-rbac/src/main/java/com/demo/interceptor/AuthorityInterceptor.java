package com.demo.interceptor;

import com.demo.core.UserContext;
import com.demo.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Set;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    private final static Logger log = LoggerFactory.getLogger(AuthorityInterceptor.class);

    @Autowired
    private ResourceService resourceService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是静态资源，直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String pattern = (String)request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        String path = request.getMethod() + ":" + pattern;

        Set<String> userPaths = resourceService.getCurrentUserMenus();
        if (userPaths.contains(path)) {
            return true;
        }

        log.warn("{} 非法访问 {}", UserContext.getCurrentUser().getUsername(), request.getRequestURI());
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 设置响应内容，结束请求
        out.write("AuthorityInterceptor 你没有访问权限");
        out.flush();
        out.close();
        return false;
    }
}
