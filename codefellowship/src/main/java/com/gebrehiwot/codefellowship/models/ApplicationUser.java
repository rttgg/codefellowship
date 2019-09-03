package com.gebrehiwot.codefellowship.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(unique = true)
    String username;

    String password;
    String firstName;
    String lastName;
    String bio;
    Date dateOfBirth;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publisher")
    List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_follow",
            joinColumns = @JoinColumn(name="followerUser"),
            inverseJoinColumns =  @JoinColumn(name = "followedUser")
    )
    Set<ApplicationUser> followedUsers;

    public Set<ApplicationUser> getMyFollowers() {
        return myFollowers;
    }

    @ManyToMany( mappedBy = "followedUsers" )
    Set<ApplicationUser> myFollowers;




    public ApplicationUser(String username, String password, String firstName, String lastName, String bio, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
    }

    public ApplicationUser(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    public String toString(){
//        return String.format("%s (%s %s)", this.username, this.firstName, this.lastName);
//
//    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setFollowedUsers(Set<ApplicationUser> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public void setMyFollowers(Set<ApplicationUser> myFollowers) {
        this.myFollowers = myFollowers;
    }

    public void followUser(ApplicationUser followedUser) {

    }

    public Set<ApplicationUser> getFollowedUsers() {
        return followedUsers;
    }

    public List<Post> getPosts() {
        return posts;
    }
}






