package com.demo.core;

import com.demo.annotation.Auth;
import com.demo.entity.Resource;
import com.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import java.util.*;

@Component
public class ApplicationStartup implements ApplicationRunner {
    @Autowired
    private RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;
    @Autowired
    private ResourceService resourceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Resource> resources = getAuthResources();
        resourceService.deleteResourcesByType("1");
        if (resources == null || resources.size() == 0) {
            return;
        }
        for (Resource resource : resources) {
            resourceService.addResource(resource);
        }
    }

    private List<Resource> getAuthResources() {
        List<Resource> resources = new LinkedList<>();

        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingInfoHandlerMapping.getHandlerMethods();
        handlerMethodMap.forEach((info, method) -> {
            Auth classAuth = method.getBeanType().getAnnotation(Auth.class);
            Auth methodAuth = method.getMethod().getAnnotation(Auth.class);

            if (classAuth == null || methodAuth == null) {
                return;
            }

            Set<RequestMethod> methods = info.getMethodsCondition().getMethods();
            if (methods.size() != 1) {
                return;
            }

            String path = methods.toArray()[0] + ":" + info.getPatternsCondition().getPatterns().toArray()[0];

            Resource resource = new Resource();
            resource.setType("1");
            resource.setPath(path);
            resource.setName(methodAuth.name());
            resource.setResourceId(classAuth.id() + methodAuth.id());
            resources.add(resource);
        });
        return resources;
    }
}
