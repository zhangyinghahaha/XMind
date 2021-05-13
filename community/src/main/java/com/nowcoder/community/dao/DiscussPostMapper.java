package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    DiscussPost selectDiscussPostById(int id);

    /**
     * @Param注解用于给参数取别名，如果只有一个参数，并且在<if></if>里面使用，则必须加别名
     * @param userId
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    int updateCommentCount(int id, int commentCount);
}
