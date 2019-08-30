package com.gebrehiwot.codefellowship.models;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String headline;
    String content;

    @ManyToOne
    ApplicationUser publisher;


    public Post(String headline, String content, ApplicationUser publisher){
        this.headline = headline;
        this.content = content;
        this.publisher = publisher;
    }


    public long getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getContent() {
        return content;
    }

    public ApplicationUser getPublisher() {
        return publisher;
    }

    public Post(){}


public String toString() {
    return String.format("this post is owned by " + this.publisher.getFirstName());
}
}