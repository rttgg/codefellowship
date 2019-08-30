package com.gebrehiwot.codefellowship.controllers;


import com.gebrehiwot.codefellowship.models.ApplicationUser;
import com.gebrehiwot.codefellowship.models.ApplicationUserRepository;
import com.gebrehiwot.codefellowship.models.Post;
import com.gebrehiwot.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class PostController {


    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;


    @GetMapping("/posts/published")
    public String publishedPost(Principal p, Model m){
        m.addAttribute("user", p);
        return "pubpost";
    }


    @PostMapping("/posts/published")
    public RedirectView publishedPost(String headline, String content, Principal p, Model m){
        ApplicationUser newUser = applicationUserRepository.findByUsername(p.getName());

        Post newPost = new Post(headline, content, newUser);
        postRepository.save(newPost);
        m.addAttribute("profile", newUser);
        m.addAttribute("user", p);

        return new RedirectView("/myprofile");
    }



}
