package com.nowcoder.community.web.core.quartz;

import com.nowcoder.community.web.modular.discusspost.entity.DiscussPost;
import com.nowcoder.community.web.modular.discusspost.service.DiscussPostService;
import com.nowcoder.community.web.modular.search.service.ElasticSearchService;
import com.nowcoder.community.web.modular.like.service.LikeService;
import com.nowcoder.community.core.constant.CommunityConstant;
import com.nowcoder.community.core.util.RedisKeyUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostScoreRefreshJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(PostScoreRefreshJob.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private ElasticSearchService elasticSearchService;

    private static Date epoch;

    static {
        try {
            epoch = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-01-01 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String redisKey = RedisKeyUtil.getPostScoreKey();
        BoundSetOperations operations = redisTemplate.boundSetOps(redisKey);

        if (operations.size() == 0) {
            logger.info("任务取消，没有需要刷新的帖子");
            return;
        }

        logger.info("[任务开始] 正在刷新帖子分数：" + operations.size());
        while (operations.size() > 0) {
            this.refresh((Integer) operations.pop());
        }
        logger.info("[任务结束] 帖子分数刷新完毕!");
    }

    private void refresh(int postId) {
        DiscussPost post = discussPostService.findDiscussPostById(postId);
        if (post == null) {
            logger.error("帖子不存在: id=" + postId);
            return;
        }

        boolean wonderful = post.getStatus() == 1;
        int commentCount = post.getCommentCount();
        long likeCount = likeService.findEntityLikeCount(CommunityConstant.ENTITY_TYPE_POST, postId);


        // 权重
        double w = (wonderful ? 75 : 0) + commentCount*10 + likeCount*2;
        // 计算分数 = 权重 + 天数
        double score = Math.log10(Math.max(w, 1)) + (post.getCreateTime().getTime() - epoch.getTime())/(1000*3600*24);
        post.setScore(score);

        // 更新分数
        discussPostService.updateScore(postId, score);
        // 同步搜索数据

        elasticSearchService.saveDiscussPost(post);
    }
}
