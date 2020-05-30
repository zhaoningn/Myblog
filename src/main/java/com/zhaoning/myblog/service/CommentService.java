package com.zhaoning.myblog.service;

import com.zhaoning.myblog.po.Comment;

import java.util.List;

/**
 * @author zhaoning
 * @date 2020/5/9 - 14:30
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
