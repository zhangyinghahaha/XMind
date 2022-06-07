package com.demo.core;

import com.demo.entity.Resource;
import com.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ying.zhang01
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private ResourceService resourceService;

    /**
     * 此方法用于鉴权过程中获取当前请求URL需要那种权限
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        HttpServletRequest request = filterInvocation.getRequest();

        List<Resource> resources = resourceService.getAllResources(1, 20);

        for (Resource resource : resources) {
            if (!resource.getType().equals("1")) {
                continue;
            }
            String[] split = resource.getPath().split(":");
            AntPathRequestMatcher ant = new AntPathRequestMatcher(split[1]);
            if (request.getMethod().equals(split[0]) && ant.matches(request)) {
                return Collections.singletonList(new SecurityConfig(String.valueOf(resource.getResourceId())));
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
