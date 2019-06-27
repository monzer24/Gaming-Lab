package com.gaming.lab.controller;

import com.gaming.lab.data.CourseRepository;
import com.gaming.lab.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/lab")
@SessionAttributes("user")
public class LabController {

    @Autowired
    private CourseRepository repo;

    @GetMapping
    public String toLab(@ModelAttribute("user") User user, @ModelAttribute("city") String city, Model model){
        System.out.println(city);
        return "/"+city;
    }

    @GetMapping("/irbid")
    public String toIrbid(){
        return null;
    }

}
