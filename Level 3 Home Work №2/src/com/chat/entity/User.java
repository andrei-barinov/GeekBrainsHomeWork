package com.chat.entity;

import com.chat.db.UserService;

public class User {
    private String nickname;
    private int id;
    private String email;
    private String password;

    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.getUser("n1@mail.com", "11"));
    }
}
