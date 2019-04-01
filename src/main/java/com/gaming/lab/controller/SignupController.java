package com.gaming.lab.controller;

import com.gaming.lab.data.User;
import com.gaming.lab.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "signup")
public class SignupController {

    private UserRepository repo;

    @Autowired
    public SignupController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String signup(Model model){
        return "signup";
    }

    @PostMapping
    public String newUser(@Valid User user, Model model, Errors error){
        if(error.hasErrors()){
            model.addAttribute("fields", error.getAllErrors());
            return "signup";
        }
        System.out.println(user.getEmail());
        if(repo.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) == null) {
            repo.save(user);
        }else{
            model.addAttribute("param");
            return "redirect:/signup?error";
        }
        System.out.println(user.toString());
        return "redirect:/login";
    }

}
