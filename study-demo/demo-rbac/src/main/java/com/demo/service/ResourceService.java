package com.demo.service;

import com.demo.core.UserContext;
import com.demo.entity.Resource;
import com.demo.entity.User;
import com.demo.mapper.ResourceMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourceService {
    private ResourceMapper resourceMapper;

    public ResourceService(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    public Set<String> getCurrentUserMenus() {
        User user = UserContext.getCurrentUser();
        List<Resource> resources = resourceMapper.getResourceByUserId(user.getUserId());
        Set<String> menus = new HashSet<>();
        resources.forEach( resource -> menus.add(resource.getPath()));
        return menus;
    }

    public List<Resource> getCurrentUserResources() {
        User user = UserContext.getCurrentUser();
        List<Resource> resources = resourceMapper.getResourceByUserId(user.getUserId());
        return resources;
    }

    public Resource getResourceById(int resourceId) {
        return resourceMapper.selectResourceById(resourceId);
    }

    public int addResource(Resource resource) {
        return resourceMapper.insertResource(resource);
    }

    public int updateResource(Resource resource) {
        return resourceMapper.updateResource(resource);
    }

    public int deleteResourceById(int resourceId) {
        return resourceMapper.deleteResourceById(resourceId);
    }
}
