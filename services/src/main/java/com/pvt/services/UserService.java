package com.pvt.services;

import com.pvt.dto.UsersDto;
import com.pvt.entities.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {

    User createUser(String name, String login, String password, int age, String sex);
    User get(Serializable id);
    void update(User user);
    void delete(User user);

    User getByLogin(String login);
    List<UsersDto> getAll();
}
