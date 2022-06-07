package com.nowcoder.community.web.core.interceptor;

import com.nowcoder.community.core.annotation.LoginRequired;
import com.nowcoder.community.core.util.CommunityUtil;
import com.nowcoder.community.core.util.HostHolder;
import com.nowcoder.community.web.modular.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author ying.zhang01
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {
    @Autowired
    private HostHolder<User> hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.getAnnotation(LoginRequired.class) != null && hostHolder.getUser() == null) {
                String xRequestedWith = request.getHeader("x-requested-with");
                if ("XMLHttpRequest".equals(xRequestedWith)) {
                    response.setContentType("application/text;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(CommunityUtil.getJsonString(1, "用户没有登录"));
                } else {
                    response.sendRedirect(request.getContextPath() + "/login");
                }
                return false;
            }
        }
        return true;
    }
}
