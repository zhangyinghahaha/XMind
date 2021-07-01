package com.nowcoder.community.service;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.nowcoder.community.service.config.CaffeineProperties;
import com.nowcoder.community.dao.dao.DiscussPostMapper;
import com.nowcoder.community.domain.entity.DiscussPost;
import com.nowcoder.community.common.util.SensitiveFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DiscussPostService {
    private static final Logger logger = LoggerFactory.getLogger(DiscussPostService.class);

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private SensitiveFilter sensitiveFilter;
    @Autowired
    private CaffeineProperties caffeineProperties;

    /**
     * 帖子列表缓存
     */
    private LoadingCache<String, List<DiscussPost>> postListCache;
    private LoadingCache<Integer, Integer> postRowsCache;

    @PostConstruct
    public void init() {
        postListCache = Caffeine.newBuilder()
                .maximumSize(caffeineProperties.getMaxSize())
                .expireAfterWrite(caffeineProperties.getExpireSeconds(), TimeUnit.SECONDS)
                .build((s -> {
                    String[] params = s.split(":");
                    if (params.length != 2) {
                        throw new IllegalArgumentException("参数异常");
                    }
                    int offset = Integer.valueOf(params[0]);
                    int limit = Integer.valueOf(params[1]);
                    // 二级缓存

                    logger.debug("load post list from DB.");
                    return discussPostMapper.selectDiscussPosts(0, offset, limit, 1);
                }));
        postRowsCache = Caffeine.newBuilder()
                .maximumSize(caffeineProperties.getMaxSize())
                .expireAfterWrite(caffeineProperties.getExpireSeconds(), TimeUnit.SECONDS)
                .build((key) -> {
                    logger.debug("load post list from DB.");
                    return discussPostMapper.selectDiscussPostRows(key);
                });
    }

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit, int orderMode) {
        if (userId == 0 && orderMode == 1) {
            return postListCache.get(offset + ":" + limit);
        }
        logger.debug("load post list from DB.");
        return discussPostMapper.selectDiscussPosts(userId, offset, limit, orderMode);
    }

    public DiscussPost findDiscussPostById(int id) {
        return discussPostMapper.selectDiscussPostById(id);
    }

    public int findDiscussPostRows(int userId) {
        if (userId == 0) {
            return postRowsCache.get(userId);
        }
        logger.debug("load post rows from DB.");
        return discussPostMapper.selectDiscussPostRows(userId);
    }

    public int addDiscussPost(DiscussPost discussPost) {
        if (discussPost == null) {
            throw new IllegalArgumentException("参数不能为空!");
        }

        // 转义HTML标签
        discussPost.setTitle(HtmlUtils.htmlEscape(discussPost.getTitle()));
        discussPost.setContent(HtmlUtils.htmlEscape(discussPost.getContent()));
        // 过滤敏感词
        discussPost.setTitle(sensitiveFilter.filter(discussPost.getTitle()));
        discussPost.setContent(sensitiveFilter.filter(discussPost.getContent()));
        return discussPostMapper.insertDiscussPost(discussPost);
    }

    public int updateCommentCount(int id, int commentCount) {
        return discussPostMapper.updateCommentCount(id, commentCount);
    }

    public int updateType(int id, int type) {
        return discussPostMapper.updateType(id, type);
    }

    public int updateStatus(int id, int status) {
        return discussPostMapper.updateStatus(id, status);
    }

    public int updateScore(int id, double score) {
        return discussPostMapper.updateScore(id, score);
    }
}
