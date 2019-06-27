package com.gaming.lab.controller;

import com.gaming.lab.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
@SessionAttributes("user")
public class RootController {

    @ModelAttribute
    public User newUser(){
        return new User();
    }

    @GetMapping
    public String toHome(User user, Model model){
        user = new User();
        model.addAttribute("user", user);
        return "redirect:home";
    }

}
