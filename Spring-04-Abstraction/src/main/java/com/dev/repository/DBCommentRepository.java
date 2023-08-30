package com.dev.repository;

import com.dev.model.Comment;

public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.printf("Storing comment: " + comment.getText());
    }
}
