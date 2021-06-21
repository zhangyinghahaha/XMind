package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class CaffeineTests {
    @Autowired
    private DiscussPostService discussPostService;

    @Test
    public void initData() {
        for (int i = 0; i < 300000; i++) {
            DiscussPost discussPost = new DiscussPost();
            discussPost.setUserId(111);
            discussPost.setTitle("压力测试");
            discussPost.setContent("压力测试");
            discussPost.setCreateTime(new Date());
            discussPost.setScore(Math.random() * 200);
            discussPostService.addDiscussPost(discussPost);
        }
    }

    @Test
    public void testCache() {
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 0));
    }
}
