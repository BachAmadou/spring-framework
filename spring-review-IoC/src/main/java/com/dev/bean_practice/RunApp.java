package com.dev.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class, AnotherConfigApp.class);

        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();

        PartTimeEmployee partTimeEmployee = context.getBean(PartTimeEmployee.class);
        partTimeEmployee.createAccount();

        String str1 = context.getBean("str1", String.class);
        System.out.println(str1);

        String str2 = context.getBean("str2", String.class);
        System.out.println(str2);
    }
}

























