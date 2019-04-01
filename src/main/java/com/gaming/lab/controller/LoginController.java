package com.gaming.lab.controller;

import com.gaming.lab.data.User;
import com.gaming.lab.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private UserRepository repo;

    @Autowired
    public LoginController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String checkUser(String userName, String password, Model model){
        System.out.println(userName + " " + password);
        User user = repo.findUserByEmailAndPassword(userName, password);
        if(user == null){
            System.out.println("error");
            model.addAttribute("param");
            return "redirect:/login?error";

        }else
        return "redirect:/home";
    }

}
