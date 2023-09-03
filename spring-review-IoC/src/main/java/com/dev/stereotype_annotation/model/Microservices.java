package com.dev.stereotype_annotation.model;

import org.springframework.stereotype.Component;

@Component
public class Microservices {
    public void getTotalHours() {
        System.out.println("Total hours : " + 25);
    }
}
