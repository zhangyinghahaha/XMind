package com.nowcoder.community.service;

import com.nowcoder.community.dao.dao.AlphaDao;
import com.nowcoder.community.dao.dao.DiscussPostMapper;
import com.nowcoder.community.dao.dao.UserMapper;
import com.nowcoder.community.domain.entity.DiscussPost;
import com.nowcoder.community.domain.entity.User;
import com.nowcoder.community.common.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public AlphaService() {
        System.out.println("AlphaService 构造");
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("AlphaService 初始化");
//    }
//
//    @PreDestroy
//    public void destroy() {
//        System.out.println("AlphaService 销毁");
//    }

    public String find() {
        return alphaDao.select();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Object save1() {
        User user = new User();
        user.setUsername("alpha");
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
        user.setEmail("alpha@qq.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/99.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);

        DiscussPost post = new DiscussPost();
        post.setTitle("Hello");
        post.setContent("新人报道!");
        post.setCreateTime(new Date());
        post.setUserId(user.getId());
        discussPostMapper.insertDiscussPost(post);

        Integer.valueOf("abc");
        return "ok";
    }

    public Object save2() {
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        return transactionTemplate.execute(status -> {
            User user = new User();
            user.setUsername("alpha");
            user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
            user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
            user.setEmail("alpha@qq.com");
            user.setHeaderUrl("http://images.nowcoder.com/head/99.png");
            user.setCreateTime(new Date());
            userMapper.insertUser(user);

            DiscussPost post = new DiscussPost();
            post.setTitle("Hello");
            post.setContent("新人报道!");
            post.setCreateTime(new Date());
            post.setUserId(user.getId());
            discussPostMapper.insertDiscussPost(post);

            Integer.valueOf("abc");
            return "ok";
        });
    }
}
