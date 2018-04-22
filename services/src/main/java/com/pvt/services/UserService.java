package com.pvt.services;

import com.pvt.dto.UsersDto;

import java.util.List;

public interface UserService<T> extends Service<T> {

    T getByLogin(String login);
    List<T> getAll();
    List<UsersDto> getAllDto();
}
