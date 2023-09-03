package com.dev.stereotype_annotation.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataStructure {

    ExtraHours extraHours;

    //   @Autowired
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }
    public void getTotalHours() {
        System.out.println("Total hours : " + 30 + (extraHours.getHours()));
    }
}
