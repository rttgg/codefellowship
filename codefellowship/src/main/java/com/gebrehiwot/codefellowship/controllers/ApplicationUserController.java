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
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ApplicationUserController {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String bio, Date dateOfBirth){
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password),firstName,lastName,bio,dateOfBirth);
        //bcrypt handles hashing/salting
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    return new RedirectView("/myprofile");
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/myprofile")
    public String getMyProfile(Principal p, Model m){
        m.addAttribute("profile", applicationUserRepository.findByUsername(p.getName()));
        m.addAttribute("user", p);
        return "myprofile";
    }

    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable long id, Model m){
        ApplicationUser searchedUser = applicationUserRepository.findById(id).get();
        m.addAttribute("searchedUser",searchedUser);
        return "user";
    }
}
