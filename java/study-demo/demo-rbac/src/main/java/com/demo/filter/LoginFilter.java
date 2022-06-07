package com.demo.filter;

import com.demo.core.JwtUtil;
import com.demo.entity.User;
import com.demo.entity.UserDetail;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangying
 */
@Component
public class LoginFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.debug(request.getRequestURI());
        String token = request.getHeader("Authorization");
        if (token != null) {
            token = token.replace("Bearer", "").trim();
        }

        // 解析token
        Claims claims = JwtUtil.parse(token);
        if (claims != null) {
            UserDetails user = userService.loadUserByUsername(claims.getSubject());
            log.info("Current User: {}", user);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    user,
                    user.getPassword(),
                    user.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
