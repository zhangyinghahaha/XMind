package com.demo.config;

import com.demo.core.AccessDeniedExceptionHandler;
import com.demo.core.AuthenticationExceptionHandler;
import com.demo.core.MyDecisionManager;
import com.demo.core.MySecurityMetadataSource;
import com.demo.filter.AuthFilter;
import com.demo.filter.LoginFilter;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author ying.zhang01
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserService userService;
    @Autowired
    private AuthenticationExceptionHandler authenticationExceptionHandler;
    @Autowired
    private LoginFilter loginFilter;
    @Autowired
    private AccessDeniedExceptionHandler accessDeniedExceptionHandler;
    @Autowired
    private MyDecisionManager accessDecisionManager;
    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }

//    @Bean
//    public AccessDecisionManager accessDecisionManager() {
//        return new MyDecisionManager();
//    }
//
//    @Bean
//    public SecurityMetadataSource securityMetadataSource() {
//        return new MySecurityMetadataSource();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/login", "/error").permitAll()
                .anyRequest().authenticated()
                .withObjectPostProcessor(
                        new ObjectPostProcessor<FilterSecurityInterceptor>() {
                            @Override
                            public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                                object.setAccessDecisionManager(accessDecisionManager);
                                object.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                                return object;
                            }
                        }
                )
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationExceptionHandler)
                .accessDeniedHandler(accessDeniedExceptionHandler);

        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
