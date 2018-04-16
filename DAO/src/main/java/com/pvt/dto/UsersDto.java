package com.pvt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersDto {
    private long userId;
    private String name;
    private String login;
//    private String password;
    private int age;
    private  String sex;
    private  String role;
    private  int booksGot;
}
