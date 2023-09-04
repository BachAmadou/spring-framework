package com.dev.repository;

import com.dev.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
