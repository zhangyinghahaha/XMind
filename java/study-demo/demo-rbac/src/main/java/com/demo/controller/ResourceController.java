package com.demo.controller;

import com.demo.annotation.Auth;
import com.demo.entity.Resource;
import com.demo.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Auth(id = 2000, name = "资源管理")
public class ResourceController {
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

//    @GetMapping("/resources/current_user")
//    public List<Integer> getCurrentUserResourceIds() {
//        return resourceService.getCurrentUserResourceIds();
//    }

    @Auth(id = 1, name = "查询资源")
    @GetMapping("/data/v1/resources")
    public List<Resource> resources(
            @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10")int pageSize
    ) {
        return resourceService.getAllResources(pageNum, pageSize);
    }

    @GetMapping("/data/v1/resources/{resourceId}")
    public Resource resourceOne(@PathVariable int resourceId) {
        return resourceService.getResourceById(resourceId);
    }

    @PostMapping("/data/v1/resources")
    public int addResource(@RequestBody Resource resource) {
        resourceService.addResource(resource);
        return resource.getResourceId();
    }

    @PutMapping("/data/v1/resources/{resourceId}")
    public int updateResource(@PathVariable int resourceId, @RequestBody Resource resource) {
        resource.setResourceId(resourceId);
        return resourceService.updateResource(resource);
    }

    @DeleteMapping("/data/v1/resources/{resourceId}")
    public int deleteResource(@PathVariable int resourceId) {
        return resourceService.deleteResourceById(resourceId);
    }
}
