package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("AlphaService 构造");
    }

    @PostConstruct
    public void init() {
        System.out.println("AlphaService 初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AlphaService 销毁");
    }

    public String find() {
        return alphaDao.select();
    }
}
