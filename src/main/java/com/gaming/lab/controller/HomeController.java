package com.gaming.lab.controller;

import com.gaming.lab.data.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes("user")
public class HomeController {

    @GetMapping
    public String uHome(@ModelAttribute User user, RedirectAttributes model){
        model.addAttribute("user", user);
        return "home";
    }

    @PostMapping("/course")
    public String toCourse(@ModelAttribute("user") User user, RedirectAttributes model){
        model.addAttribute("user", user);
        return "redirect:/course";
    }

    @PostMapping("/irbid")
    public String toIrbid(@ModelAttribute("user") User user, Model model){
        String city = "irbid";
        model.addAttribute("city", city);
        return "redirect:/lab";
    }


//    @GetMapping("/current")
//    public String home(@ModelAttribute("user") User user, Model model){
//        System.out.println("home " +user.toString());
//        model.addAttribute(user);
//        return "home";
//    }
//
//    @GetMapping
//    public String unHome(){
//        return "home";
//    }
//
//    public String login(@ModelAttribute User user,  Model model) throws HttpSessionRequiredException{
//        if(user.getId() == null){
//            return "login/course";
////            throw new HttpSessionRequiredException("You are not logged in");
//        }
//        System.out.println("success");
//        System.out.println(user.toString());
//        model.addAttribute(user);
//        return "course";
//    }
//
//    @PostMapping("/course")
//    public String course(@ModelAttribute("user") User user, Model model) {
//        System.out.println("Home : " + user);
//        String s = null;
//        try {
//            s = login(user, model);
//        } catch (HttpSessionRequiredException e) {
//            e.printStackTrace();
//        }
//        model.addAttribute(user);
//        return "redirect:/"+s;
//    }

}
