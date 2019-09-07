package com.gebrehiwot.codefellowship.controllers;


import com.gebrehiwot.codefellowship.models.ApplicationUser;
import com.gebrehiwot.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;


    @GetMapping("/")
    public String getRoot(Principal p, Model m){
        ApplicationUser applicationUser = null;

        if(p != null){
            applicationUser = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("viewuser", applicationUser);
            m.addAttribute("user", p);
            //return "/myprofile";
        }

        return "root";
    }
    @GetMapping("/signup")
    public String getSignupPage(){

        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}





