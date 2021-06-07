package com.nowcoder.community.controller;

import com.nowcoder.community.entity.*;
import com.nowcoder.community.event.EventProducer;
import com.nowcoder.community.event.EventTopicConstants;
import com.nowcoder.community.service.CommentService;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.LikeService;
import com.nowcoder.community.service.UserService;
import com.nowcoder.community.util.CommunityConstant;
import com.nowcoder.community.util.CommunityUtil;
import com.nowcoder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author ying.zhang01
 */
@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private EventProducer eventProducer;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(String title, String content) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJsonString(403, "你还没有登录");
        }

        DiscussPost post = new DiscussPost();
        post.setTitle(title);
        post.setContent(content);
        post.setUserId(user.getId());
        post.setCreateTime(new Date());
        discussPostService.addDiscussPost(post);

        // 触发发帖事件
        Event event = new Event()
                .setTopic(EventTopicConstants.TOPIC_PUBLISH)
                .setUserId(user.getId())
                .setEntityType(CommunityConstant.ENTITY_TYPE_POST)
                .setEntityId(post.getId());
        eventProducer.fireEvent(event);

        // 报错的情况，后面统一处理
        return CommunityUtil.getJsonString(0, "发布成功");
    }

    @RequestMapping(path = "/detail/{discussPostId}", method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model, Page page) {
        // 帖子
        DiscussPost discussPost = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post", discussPost);

        // 作者
        User user = userService.findUserById(discussPost.getUserId());
        model.addAttribute("user", user);

        // 点赞数量、状态
        long likeCount = likeService.findEntityLikeCount(CommunityConstant.ENTITY_TYPE_POST, discussPost.getId());
        model.addAttribute("likeCount", likeCount);
        int likeStatus = 0;
        if (hostHolder.getUser()!=null) {
            likeStatus = likeService.findEntityLikeStatus(hostHolder.getUser().getId(), CommunityConstant.ENTITY_TYPE_POST, discussPost.getId());
        }
        model.addAttribute("likeStatus", likeStatus);

        // 评论信息
        page.setLimit(5);
        page.setPath("/discuss/detail/" + discussPostId);
        page.setRows(discussPost.getCommentCount());

        List<Comment> comments = commentService.findCommentByEntity(
                CommunityConstant.ENTITY_TYPE_POST, discussPost.getId(), page.getOffset(), page.getLimit()
        );
        List<Map<String, Object>> commentVoList = new ArrayList<>();
        if (comments != null) {
            for (Comment comment : comments) {
                Map<String, Object> commentVo = new HashMap<>();
                commentVo.put("comment", comment);
                commentVo.put("user", userService.findUserById(comment.getUserId()));
                // 点赞数量、状态
                long commentLikeCount = likeService.findEntityLikeCount(CommunityConstant.ENTITY_TYPE_COMMENT, comment.getId());
                commentVo.put("likeCount", commentLikeCount);
                int commentLikeStatus = 0;
                if (hostHolder.getUser()!=null) {
                    commentLikeStatus = likeService.findEntityLikeStatus(hostHolder.getUser().getId(), CommunityConstant.ENTITY_TYPE_COMMENT, comment.getId());
                }
                commentVo.put("likeStatus", commentLikeStatus);

                List<Comment> replyList = commentService.findCommentByEntity(
                        CommunityConstant.ENTITY_TYPE_COMMENT, comment.getId(), 0, Integer.MAX_VALUE
                );
                List<Map<String, Object>> replyVoList = new ArrayList<>();
                if (replyList != null) {
                    for (Comment reply : replyList) {
                        Map<String, Object> replyVo = new HashMap<>();
                        replyVo.put("reply", reply);
                        replyVo.put("user", userService.findUserById(reply.getUserId()));
                        User target = reply.getTargetId() == 0 ? null : userService.findUserById(reply.getUserId());
                        replyVo.put("target", target);
                        // 点赞数量、状态
                        long replayLikeCount = likeService.findEntityLikeCount(CommunityConstant.ENTITY_TYPE_COMMENT, reply.getId());
                        replyVo.put("likeCount", replayLikeCount);
                        int replayLikeStatus = 0;
                        if (hostHolder.getUser()!=null) {
                            replayLikeStatus = likeService.findEntityLikeStatus(hostHolder.getUser().getId(), CommunityConstant.ENTITY_TYPE_COMMENT, reply.getId());
                        }
                        replyVo.put("likeStatus", replayLikeStatus);
                        replyVoList.add(replyVo);
                    }
                }
                commentVo.put("replys", replyVoList);

                int replyCount = commentService.findtCommentCountByEntity(CommunityConstant.ENTITY_TYPE_COMMENT, comment.getId());
                commentVo.put("replyCount", replyCount);

                commentVoList.add(commentVo);
            }
        }

        model.addAttribute("comments", commentVoList);

        return "/site/discuss-detail";
    }

    @RequestMapping(path = "/top", method = RequestMethod.POST)
    @ResponseBody
    public String setTop(int id) {
        discussPostService.updateType(id, 1);

        // 触发帖子更新事件
        Event event = new Event()
                .setTopic(EventTopicConstants.TOPIC_PUBLISH)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(CommunityConstant.ENTITY_TYPE_POST)
                .setEntityId(id);
        eventProducer.fireEvent(event);
        return CommunityUtil.getJsonString(0);
    }

    @RequestMapping(path = "/wonderful", method = RequestMethod.POST)
    @ResponseBody
    public String setWonderful(int id) {
        discussPostService.updateStatus(id, 1);
        // 触发帖子更新事件
        Event event = new Event()
                .setTopic(EventTopicConstants.TOPIC_PUBLISH)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(CommunityConstant.ENTITY_TYPE_POST)
                .setEntityId(id);
        eventProducer.fireEvent(event);
        return CommunityUtil.getJsonString(0);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id) {
        discussPostService.updateStatus(id, 2);
        // 触发删帖事件
        Event event = new Event()
                .setTopic(EventTopicConstants.TOPIC_DELETE)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(CommunityConstant.ENTITY_TYPE_POST)
                .setEntityId(id);
        eventProducer.fireEvent(event);
        return CommunityUtil.getJsonString(0);
    }
}
