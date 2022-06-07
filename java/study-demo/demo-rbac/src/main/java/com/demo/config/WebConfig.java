package com.demo.config;

import com.demo.interceptor.AuthorityInterceptor;
import com.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhangying
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private LoginInterceptor loginInterceptor;
    private AuthorityInterceptor authorityInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor, AuthorityInterceptor authorityInterceptor) {
        this.loginInterceptor = loginInterceptor;
        this.authorityInterceptor = authorityInterceptor;
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).excludePathPatterns("/login", "/hello", "/error");
//        registry.addInterceptor(authorityInterceptor).excludePathPatterns("/login", "/index", "/hello", "/error");
//    }
}
