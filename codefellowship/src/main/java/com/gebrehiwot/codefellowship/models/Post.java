package com.gebrehiwot.codefellowship.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //String headline;
    String content;
    String createdAt;

    @ManyToOne
    ApplicationUser publisher;

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public ApplicationUser getPublisher() {
        return publisher;
    }

    public Post(String content, ApplicationUser publisher){
        //this.headline = headline;
        this.content = content;
//        this.createdAt= createdAt;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        this.createdAt = sdf.format(new Timestamp(System.currentTimeMillis()).getTime());

        this.publisher = publisher;
    }


    public long getId() {
        return id;
    }

    public Post(){}


//public String toString() {
//    return String.format("this post is owned by " + this.publisher.getFirstName());
//}
}

