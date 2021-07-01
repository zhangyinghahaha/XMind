package com.nowcoder.community.web.config;

import com.nowcoder.community.web.controller.filter.LoginTicketFilter;
import com.nowcoder.community.common.util.CommunityConstant;
import com.nowcoder.community.common.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;

/**
 * @author zhangying
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginTicketFilter loginTicketFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略对静态资源的拦截
        web.ignoring().antMatchers("/resources/**");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // AuthenticationManager: 认证的核心接口
//        // AuthenticationManagerBuilder: 用于构建AuthenticationManager对象的工具, ProviderManager是AuthenticationManager接口的默认实现
//        // AuthenticationProvider: AuthenticationManager持有一组AuthenticationProvider，每个AuthenticationProvider负责一种认证(密码，指纹)
//
//        // 内置的认证规则
//        // auth.userDetailsService(userService).passwordEncoder(new Pbkdf2PasswordEncoder("12345"));
//
//        // 自定义认证规则
//        auth.authenticationProvider(new AuthenticationProvider() {
//            /**
//             * 用于封装认证信息的接口,不同的实现类代表不同类型的认证信息
//             * @param authentication
//             * @return
//             * @throws AuthenticationException
//             */
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                String username = authentication.getName();
//                String password = (String) authentication.getCredentials();
//                User user = userService.findUserByName(username);
//                if (user == null) {
//                    throw new UsernameNotFoundException("账号不存在!");
//                }
//                password = CommunityUtil.md5(password + user.getSalt());
//                if (!user.getPassword().equals(password)) {
//                    throw new BadCredentialsException("密码不正确!");
//                }
//                return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
//            }
//
//            /**
//             * 支持的认证类型
//             * @param aClass
//             * @return
//             */
//            @Override
//            public boolean supports(Class<?> aClass) {
//                return UsernamePasswordAuthenticationToken.class.equals(aClass);
//            }
//        });
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录相关配置
//        http.formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
//                    httpServletResponse.sendRedirect("");
//                })
//                .failureHandler((httpServletRequest, httpServletResponse, authentication) -> {});

        // 禁用security session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 登录凭证校验
        http.addFilterBefore(loginTicketFilter, UsernamePasswordAuthenticationFilter.class);

        // 退出相关配置,覆盖默认的退出
        http.logout().logoutUrl("/security/logout");

        // 授权配置
        http.authorizeRequests()
                .antMatchers(
                        "/user/setting",
                        "/user/upload",
                        "/discuss/add",
                        "/comment/add/**",
                        "/letter/**",
                        "/notice/**",
                        "/like",
                        "/follow",
                        "/unfollow"
                )
                .hasAnyAuthority(
                        CommunityConstant.AUTHORITY_USER,
                        CommunityConstant.AUTHORITY_ADMIN,
                        CommunityConstant.AUTHORITY_MODERATOR
                )
                .antMatchers(
                        "/discuss/top",
                        "/discuss/wonderful"
                )
                .hasAnyAuthority(
                        CommunityConstant.AUTHORITY_ADMIN,
                        CommunityConstant.AUTHORITY_MODERATOR
                )
                .antMatchers(
                        "/discuss/delete",
                        "/data/**"
                )
                .hasAnyAuthority(
                        CommunityConstant.AUTHORITY_ADMIN
                )
                .anyRequest().permitAll()
                .and().csrf().disable();

        // 权限不够时
        http.exceptionHandling()
                .authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                   // 没有登录
                    String xRequestedWith = httpServletRequest.getHeader("x-requested-with");
                    if ("XMLHttpRequest".equals(xRequestedWith)) {
                        httpServletResponse.setContentType("application/text;charset=utf-8");
                        PrintWriter writer = httpServletResponse.getWriter();
                        writer.write(CommunityUtil.getJsonString(403, "你还没有登录!"));
                    } else {
                        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
                    }
                })
                .accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> {
                    // 权限不足
                    String xRequestedWith = httpServletRequest.getHeader("x-requested-with");
                    if ("XMLHttpRequest".equals(xRequestedWith)) {
                        httpServletResponse.setContentType("application/text;charset=utf-8");
                        PrintWriter writer = httpServletResponse.getWriter();
                        writer.write(CommunityUtil.getJsonString(403, "访问权限不足!"));
                    } else {
                        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/denied");
                    }
                });

//        http.addFilterBefore((servletRequest, servletResponse, filterChain) -> {
//            HttpServletRequest request = (HttpServletRequest) servletRequest;
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            if (request.getServletPath().equals("/login")) {
//                String verifyCode = request.getParameter("verifyCode");
//                if (verifyCode == null) {
//                    request.setAttribute("error", "验证码错误");
//                    request.getRequestDispatcher("/loginPage").forward(request, response);
//                    return;
//                }
//            }
//            // 让请求继续向下执行
//            filterChain.doFilter(request, response);
//        }, UsernamePasswordAuthenticationFilter.class);
//
//        // 记住我
//        http.rememberMe()
//                .tokenRepository(new InMemoryTokenRepositoryImpl())
//                .tokenValiditySeconds(3600*24)
//                .userDetailsService(userService);
    }
}
