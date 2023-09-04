package com.dev;

import com.dev.model.Comment;
import com.dev.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BachApplication {
	public static void main(String[] args) {

		Comment comment = new Comment();
		comment.setAuthor("Bach");
		comment.setText("Spring development ");

		ApplicationContext context =  SpringApplication.run(BachApplication.class, args);

		CommentService cs = context.getBean(CommentService.class);
		cs.publishComment(comment);
	}

}
