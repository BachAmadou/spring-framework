package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "Java course");
        model.addAttribute("course", "MVC");

        String subject = "Collections, API";
        model.addAttribute("subject", subject);

        int studentID = new Random().nextInt(100) ;
        model.addAttribute("studentID", studentID);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        model.addAttribute("numbers", numbers);


        return "student/welcome";
    }
}
