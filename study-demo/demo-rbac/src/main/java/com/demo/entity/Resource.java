package com.demo.entity;

/**
 * @author zhangying
 */
public class Resource {
    private int resourceId;
    private int userId;
    private String path;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                ", userId=" + userId +
                ", path='" + path + '\'' +
                '}';
    }
}
