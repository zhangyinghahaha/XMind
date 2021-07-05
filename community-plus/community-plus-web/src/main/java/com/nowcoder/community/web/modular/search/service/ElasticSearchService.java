package com.nowcoder.community.web.modular.search.service;

import com.nowcoder.community.dao.elasticsearch.DiscussPostRepository;
import com.nowcoder.community.entity.DiscussPost;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchService {
    @Autowired
    private DiscussPostRepository discussPostRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public void saveDiscussPost(DiscussPost post) {
        discussPostRepository.save(post);
    }

    public void deleteDiscussPost(int id) {
        discussPostRepository.deleteById(id);
    }

    public SearchHits<DiscussPost> searchDiscussPost(String keyword, int current, int limit) {
        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyword, "title", "content"))
                .withSort(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                .withPageable(PageRequest.of(current, limit))
                .withHighlightFields(
                        new HighlightBuilder.Field("title").preTags("<em>").postTags("</em>"),
                        new HighlightBuilder.Field("content").preTags("<em>").postTags("</em>")
                ).build();
        SearchHits<DiscussPost> searchHits = elasticsearchRestTemplate.search(query, DiscussPost.class);
        for (SearchHit<DiscussPost> searchHit : searchHits) {
            if (!searchHit.getHighlightField("title").isEmpty()) {
                String highlightTitle = searchHit.getHighlightField("title").get(0);
                searchHit.getContent().setTitle(highlightTitle);
            }

            if (!searchHit.getHighlightField("content").isEmpty()) {
                String highlightContent = searchHit.getHighlightField("content").get(0);
                searchHit.getContent().setContent(highlightContent);
            }
        }

        return searchHits;
    }
}
