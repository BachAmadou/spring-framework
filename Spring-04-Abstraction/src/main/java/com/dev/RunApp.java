package com.dev;

import com.dev.config.ProjectConfig;
import com.dev.model.Comment;
import com.dev.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Bach");
        comment.setText("Spring development ");

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService =  context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}











