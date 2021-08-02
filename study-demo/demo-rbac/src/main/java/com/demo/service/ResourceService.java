package com.demo.service;

import com.demo.core.UserContext;
import com.demo.entity.Resource;
import com.demo.entity.User;
import com.demo.mapper.ResourceMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourceService {
    private ResourceMapper resourceMapper;

    public ResourceService(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    public Set<String> getCurrentUserMenus() {
        Set<String> menus = new HashSet<>();
        List<Integer> resourceIds = getCurrentUserResourceIds();
        for (Integer resourceId : resourceIds) {
            Resource resource = getResourceById(resourceId);
            menus.add(resource.getPath());
        }
        return menus;
    }

    public List<Integer> getCurrentUserResourceIds() {
        // User user = UserContext.getCurrentUser();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return getResourceIdsByUserId(user.getUserId());
    }

    public List<Resource> getAllResources(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> resourceMapper.selectAllResources());
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

    public List<Integer> getResourceIdsByUserId(int userId) {
        return resourceMapper.selectResourceIdsByUserId(userId);
    }

    public int deleteResourcesByType(String type) {
        return resourceMapper.deleteResourcesByType(type);
    }
}
