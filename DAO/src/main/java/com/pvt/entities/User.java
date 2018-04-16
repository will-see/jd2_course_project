package com.pvt.entities;

import lombok.Data;

@Data
public class User {
    private long userId;
    private String name;
    private String login;
    private String password;
    private int age;
    private  String sex;
//    private  String status;
    private  String role;
}

