package com.nowcoder.community.web.modular.like.controller;

import com.nowcoder.community.core.annotation.LoginRequired;
import com.nowcoder.community.web.core.event.Event;
import com.nowcoder.community.web.modular.user.entity.User;
import com.nowcoder.community.web.core.event.EventProducer;
import com.nowcoder.community.web.core.constant.EventTopicConstants;
import com.nowcoder.community.web.modular.like.service.LikeService;
import com.nowcoder.community.core.constant.CommunityConstant;
import com.nowcoder.community.core.util.CommunityUtil;
import com.nowcoder.community.core.util.HostHolder;
import com.nowcoder.community.core.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ying.zhang01
 */
@Controller
public class LikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private HostHolder<User> hostHolder;
    @Autowired
    private EventProducer eventProducer;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(path="/like", method = RequestMethod.POST)
    @LoginRequired
    @ResponseBody
    public String like(int entityType, int entityId, int entityUserId, int postId) {
        User user = hostHolder.getUser();

        // 点赞
        likeService.like(user.getId(), entityType, entityId, entityUserId);
        // 返回点赞数量和状态
        long likeCount = likeService.findEntityLikeCount(entityType, entityId);
        int likeStatus = likeService.findEntityLikeStatus(user.getId(), entityType, entityId);

        Map<String, Object> map = new HashMap<>();
        map.put("likeCount", likeCount);
        map.put("likeStatus", likeStatus);

        // 触发点赞事件
        if (likeStatus == 1) {
            Event event = new Event();
            event.setTopic(EventTopicConstants.TOPIC_LIKE)
                    .setUserId(hostHolder.getUser().getId())
                    .setEntityType(entityType)
                    .setEntityId(entityId)
                    .setEntityUserId(entityUserId)
                    .setData("postId", postId);
            eventProducer.fireEvent(event);
        }

        // 计算帖子分数
        if (entityType == CommunityConstant.ENTITY_TYPE_POST) {
            String redisKey = RedisKeyUtil.getPostScoreKey();
            redisTemplate.opsForSet().add(redisKey, postId);
        }

        return CommunityUtil.getJsonString(0, null, map);
    }
}
