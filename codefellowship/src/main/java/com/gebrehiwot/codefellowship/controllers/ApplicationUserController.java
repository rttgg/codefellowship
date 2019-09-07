package com.gebrehiwot.codefellowship.controllers;


import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.gebrehiwot.codefellowship.models.ApplicationUser;
import com.gebrehiwot.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;
import java.util.*;

@Controller
public class ApplicationUserController {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String bio, Date dateOfBirth){
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password),firstName,lastName,bio,dateOfBirth);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
          return new RedirectView("/myprofile");
    }


    @GetMapping("/myprofile")
    public String getMyProfile(Principal p, Model m){
        ApplicationUser applicationUser = null;
        if(p != null){
            applicationUser = applicationUserRepository.findByUsername(p.getName());
        }
        m.addAttribute("user", p);
        m.addAttribute("viewuser", applicationUser);
        return "myprofile";
    }



    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable long id, Principal p, Model m){
        ApplicationUser searchedUser = applicationUserRepository.findById(id).get();
        m.addAttribute("user", p);
        m.addAttribute("viewuser", searchedUser);
        return "myprofile";
    }

    @GetMapping("/users")
    public String getAllUsers(Model m, Principal p){
        //ApplicationUser applicationUser = null;

        if(p != null) {
            m.addAttribute("user", p);
        }

        m.addAttribute("allUsers", applicationUserRepository.findAll());
        return "allUser";
    }

    @PostMapping("/follow/{id}")
    public RedirectView whoToFollow(@PathVariable long id, Principal p){
        ApplicationUser userWhoLoggedIn = applicationUserRepository.findByUsername(p.getName());

        userWhoLoggedIn.followUser(applicationUserRepository.findById(id).get());
        applicationUserRepository.save(userWhoLoggedIn);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/feed")
    public String findFeed(Principal p, Model m){

            if(p != null){
                m.addAttribute("user", p);
            }
            m.addAttribute("loggedInUser", applicationUserRepository.findByUsername(p.getName()));
            return "feed";
        }

    }


