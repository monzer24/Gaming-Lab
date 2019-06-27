package com.gaming.lab.controller;

import com.gaming.lab.data.Course;
import com.gaming.lab.data.CourseRepository;
import com.gaming.lab.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="course")
@SessionAttributes("user")
public class CourseController {

    private CourseRepository repo;

    @Autowired
    public CourseController(CourseRepository repo) {
        this.repo = repo;
    }

//
//    @GetMapping
//    public String course(@ModelAttribute("user") User user,  Model model){
//        System.out.println("course");
//        System.out.println(user);
//        List<Course> course = repo.findAll();
//        model.addAttribute("course", course);
//        System.out.println(course.size());
//        return "course";
//    }

    @GetMapping
    public String courses(@ModelAttribute("user") User user, Model model){
        if(user == null || user.getId() == null){
            model.addAttribute(user);
            return "redirect:/login/course";
        }
        return "redirect:/course/logged";
    }

    @GetMapping("logged")
    public String getIn(@ModelAttribute("user") User user, Model model){
        List<Course> course = repo.findAll();
        model.addAttribute("course", course);
        model.addAttribute(user);
        return "/course";
    }

    @PostMapping
    public void enroll(@ModelAttribute("user") User user, String courseId, Model model, SessionStatus status){
        Optional<Course> course = repo.findById(courseId);
        if(course.isPresent()){
            course.get().addStudent(user);
            repo.save(course.get());
        }
    }

}
