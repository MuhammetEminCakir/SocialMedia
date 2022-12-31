package com.eren.javaodev.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String surname;
    private String email;

    private String userName;
    private String password;

    private String imgUrl;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> postList;

    public User() {
    }

    public User(int userId, String name, String surname, String email, String userName, String password, String imgUrl, List<Post> postList) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.imgUrl = imgUrl;
        this.postList = postList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
