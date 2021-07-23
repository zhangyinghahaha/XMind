package com.demo.entity;

/**
 * @author zhangying
 */
public class Resource {
    private int resourceId;
    private String name;
    private String path;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", name=" + name +
                ", path='" + path + '\'' +
                '}';
    }
}
