package com.dev.stereotype_annotation;

import com.dev.stereotype_annotation.config.ConfigApp;
import com.dev.stereotype_annotation.model.DataStructure;
import com.dev.stereotype_annotation.model.Microservices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        DataStructure dataStructure = context.getBean(DataStructure.class);
        dataStructure.getTotalHours();

        Microservices microservices = context.getBean(Microservices.class);
        microservices.getTotalHours();

    }
}
