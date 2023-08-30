package com.dev.proxy;

import com.dev.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
