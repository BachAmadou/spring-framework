package com.dev.repository;

import com.dev.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.printf("Storing comment: " + comment.getText());
    }
}
