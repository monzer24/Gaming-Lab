package com.gaming.lab.controller;

import com.gaming.lab.data.Course;
import com.gaming.lab.data.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(value="course")
public class CourseController {

    @Autowired
    private GridFsOperations options;
    private CourseRepository repo;

    @Autowired
    public CourseController(CourseRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String courses(Model model){
        List<Course> course = repo.findAll();
        model.addAttribute("course", course);
        return "course";
    }

}
