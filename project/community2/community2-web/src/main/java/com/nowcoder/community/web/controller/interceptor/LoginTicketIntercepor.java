package com.nowcoder.community.web.controller.interceptor;

import com.nowcoder.community.domain.entity.LoginTicket;
import com.nowcoder.community.domain.entity.User;
import com.nowcoder.community.service.UserService;
import com.nowcoder.community.common.util.CookieUtil;
import com.nowcoder.community.common.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginTicketIntercepor implements HandlerInterceptor {
    @Autowired
    private HostHolder hostHolder;

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 从cookie中获取凭证
//        String ticket = CookieUtil.getValue(request, "ticket");
//        if (ticket != null) {
//            // 查询凭证
//            LoginTicket loginTicket = userService.findLoginTicket(ticket);
//            // 检查凭证
//            if (loginTicket != null && loginTicket.getStatus() == 0 && loginTicket.getExpired().after(new Date())) {
//                // 查询凭证用户
//                User user = userService.findUserById(loginTicket.getUserId());
//                hostHolder.setUser(user);
//
//                // 构建用户认证的结果，存入SecurityContext
//                Authentication authentication = new UsernamePasswordAuthenticationToken(
//                        user, user.getPassword(), userService.getAuthorities(user.getId())
//                );
//                SecurityContextHolder.setContext(new SecurityContextImpl(authentication));
//            }
//        }
//        return true;
//    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = hostHolder.getUser();
        if (user != null && modelAndView != null) {
            modelAndView.addObject("loginUser", user);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.remove();
    }
}
