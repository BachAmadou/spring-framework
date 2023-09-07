package com.dev.controller;

import com.dev.enums.Gender;
import com.dev.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String showTable(Model model) {

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Bob", "Bach", 30, Gender.MALE));
        mentorList.add(new Mentor("Method", "Man", 39, Gender.MALE));
        mentorList.add(new Mentor("Red", "Man", 20, Gender.MALE));

        model.addAttribute("mentors", mentorList);

        return "mentor/mentor-list";
    }
}
