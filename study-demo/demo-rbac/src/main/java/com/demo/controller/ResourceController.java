package com.demo.controller;

import com.demo.entity.Resource;
import com.demo.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<Resource> resources() {
        return resourceService.getCurrentUserResources();
    }

    @GetMapping("/resources/{resourceId}")
    public Resource resourceOne(@PathVariable int resourceId) {
        return resourceService.getResourceById(resourceId);
    }

    @PostMapping("/resources")
    public int addResource(@RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }

    @PutMapping("/resources/{resourceId}")
    public int updateResource(@PathVariable int resourceId, @RequestBody Resource resource) {
        resource.setResourceId(resourceId);
        return resourceService.updateResource(resource);
    }

    @DeleteMapping("/resources/{resourceId}")
    public int deleteResource(@PathVariable int resourceId) {
        return resourceService.deleteResourceById(resourceId);
    }
}
