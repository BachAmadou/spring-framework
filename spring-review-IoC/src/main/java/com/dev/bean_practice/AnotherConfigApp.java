package com.dev.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfigApp {
    @Bean
    public String str1() {
        return "Welcome to this course";
    }

    @Bean
    public String str2() {
        return "Spring is a nice framework";
    }

}
