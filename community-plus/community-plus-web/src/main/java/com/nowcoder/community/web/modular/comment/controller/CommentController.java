package com.nowcoder.community.web.modular.comment.controller;

import com.nowcoder.community.core.annotation.LoginRequired;
import com.nowcoder.community.web.modular.comment.entity.Comment;
import com.nowcoder.community.web.modular.discusspost.entity.DiscussPost;
import com.nowcoder.community.web.core.event.Event;
import com.nowcoder.community.web.core.event.EventProducer;
import com.nowcoder.community.web.core.constant.EventTopicConstants;
import com.nowcoder.community.web.modular.comment.service.CommentService;
import com.nowcoder.community.web.modular.discusspost.service.DiscussPostService;
import com.nowcoder.community.core.constant.CommunityConstant;
import com.nowcoder.community.core.util.HostHolder;
import com.nowcoder.community.core.util.RedisKeyUtil;
import com.nowcoder.community.web.modular.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author ying.zhang01
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private HostHolder<User> hostHolder;
    @Autowired
    private EventProducer eventProducer;
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private RedisTemplate redisTemplate;

    @LoginRequired
    @RequestMapping(value = "/add/{discussPostId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") int discussPostId, Comment comment) {
        comment.setUserId(hostHolder.getUser().getId());
        comment.setStatus(0);
        comment.setCreateTime(new Date());
        commentService.addComment(comment);

        // 触发评论事件
        Event event = new Event();
        event.setTopic(EventTopicConstants.TOPIC_COMMENT)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(comment.getEntityType())
                .setEntityId(comment.getEntityId())
                .setData("postId", discussPostId);
        if (comment.getEntityType() == CommunityConstant.ENTITY_TYPE_POST) {
            DiscussPost target = discussPostService.findDiscussPostById(comment.getEntityId());
            event.setEntityUserId(target.getUserId());
        } else if (comment.getEntityType() == CommunityConstant.ENTITY_TYPE_COMMENT) {
            Comment target = commentService.findCommentById(comment.getEntityId());
            event.setEntityUserId(target.getUserId());
        }
        eventProducer.fireEvent(event);

        // 触发发帖事件
        if (comment.getEntityType() == CommunityConstant.ENTITY_TYPE_POST) {
            event.setTopic(EventTopicConstants.TOPIC_PUBLISH)
                    .setUserId(comment.getUserId())
                    .setEntityType(CommunityConstant.ENTITY_TYPE_POST)
                    .setEntityId(discussPostId);
            eventProducer.fireEvent(event);
        }

        // 计算帖子分数
        String redisKey = RedisKeyUtil.getPostScoreKey();
        redisTemplate.opsForSet().add(redisKey, discussPostId);

        return "redirect:/discuss/detail/" + discussPostId;
    }
}
