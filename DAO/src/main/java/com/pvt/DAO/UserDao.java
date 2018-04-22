package com.pvt.DAO;

import com.pvt.dto.UsersDto;
import com.pvt.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao<T> extends DAO<T> {
    T getByLogin(String login) throws SQLException;
    List<T> getAll() throws SQLException;
    List<UsersDto> getAllDto() throws SQLException;
}
