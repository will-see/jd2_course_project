package com.pvt.DAO;

import com.pvt.dto.UsersDto;
import com.pvt.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends DAO<User> {
    User getByLogin(String login) throws SQLException;
    List<UsersDto> getAll() throws SQLException;
//    List<UsersDto> getAllDto() throws SQLException;
//    List<User> getAll() throws SQLException;
}
