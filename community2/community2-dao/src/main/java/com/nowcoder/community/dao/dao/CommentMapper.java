package com.nowcoder.community.dao.dao;

import com.nowcoder.community.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ying.zhang01
 */
@Mapper
public interface CommentMapper {
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    int selectCountByEntity(int entityType, int entityId);

    int insertComment(Comment comment);

    Comment selectCommentById(int id);
}
