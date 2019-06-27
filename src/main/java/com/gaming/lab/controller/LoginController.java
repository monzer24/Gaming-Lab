package com.gaming.lab.controller;

import com.gaming.lab.data.User;
import com.gaming.lab.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/login")
@SessionAttributes("user")
public class LoginController {

    private UserRepository repo;
    private boolean flag;

    @Autowired
    public LoginController(UserRepository repo) {
        this.repo = repo;
        flag = false;
    }

    @GetMapping
    public String login(Model model){
        model.addAttribute("arg", 0);
        return "login";
    }

    @GetMapping("/course")
    public String courseLogIn(){
        flag = true;
        System.out.println(flag);
        return "redirect:/login";
    }

    @PostMapping
    public String checkUser(String email, String password, @ModelAttribute("user") User user, Model model){
        user = repo.findUserByEmail(email);
        if(user == null){
            model.addAttribute("arg", 1);
            log.info("wrong username : " + model);
            return "/login";
        }else {
            if(user.getPassword().equals(password)){
                model.addAttribute("user", user);
                return "redirect:/course/logged";
            }else{
                log.info("wrong password : " + model);
                model.addAttribute("arg",2);
                return "/login";
            }
        }
    }

}
//        }else{
//            System.out.println(flag);
//            if(flag) {


//                model.addAttribute("user",user);
//                System.out.println("modeling" + model);
//                return "redirect:/course/logged";
//            }
//            else
//                return "redirect:/home/current";
//        }