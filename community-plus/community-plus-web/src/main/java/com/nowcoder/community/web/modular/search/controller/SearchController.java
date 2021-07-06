package com.nowcoder.community.web.modular.search.controller;

import com.nowcoder.community.web.modular.discusspost.entity.DiscussPost;
import com.nowcoder.community.core.pojo.Page;
import com.nowcoder.community.web.modular.search.service.ElasticSearchService;
import com.nowcoder.community.web.modular.like.service.LikeService;
import com.nowcoder.community.web.modular.user.service.UserService;
import com.nowcoder.community.core.constant.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    private ElasticSearchService elasticSearchService;
    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String search(String keyword, Page page, Model model) {
        SearchHits<DiscussPost> searchHits = elasticSearchService.searchDiscussPost(keyword, page.getCurrent() - 1, page.getLimit());

        // 聚合数据
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (searchHits != null) {
            for (SearchHit<DiscussPost> searchHit : searchHits) {
                DiscussPost post = searchHit.getContent();
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                map.put("user", userService.findUserById(post.getUserId()));
                map.put("likeCount", likeService.findEntityLikeCount(CommunityConstant.ENTITY_TYPE_POST, post.getId()));

                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        model.addAttribute("keyword", keyword);

        page.setPath("/search?keyword=" + keyword);
        page.setRows(searchHits == null ? 0 : (int) searchHits.getTotalHits());
        return "/site/search";
    }
}
