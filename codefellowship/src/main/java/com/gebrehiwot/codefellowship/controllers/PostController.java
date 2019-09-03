package com.gebrehiwot.codefellowship.controllers;


import com.gebrehiwot.codefellowship.models.ApplicationUser;
import com.gebrehiwot.codefellowship.models.ApplicationUserRepository;
import com.gebrehiwot.codefellowship.models.Post;
import com.gebrehiwot.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;



@Controller
public class PostController {


    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;


    @GetMapping("/posts")
    public String publishedPost(Principal p, Model m){
       // List<Post> posts = postRepository.findAll();

        m.addAttribute("user", p);
        return "post";
    }


    @PostMapping("/posts")
    public RedirectView publishedPost(String content, Principal p, Model m){
        ApplicationUser newUser = applicationUserRepository.findByUsername(p.getName());

        Post newPost = new Post(content, newUser);
        postRepository.save(newPost);


        return new RedirectView("/users/" + newUser.getId());
    }
//
//    private boolean getId() {
//        return false;
//    }


}

