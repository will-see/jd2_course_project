package com.pvt.services.impl;

import com.pvt.DAO.UserDao;
import com.pvt.DAO.impl.UserDaoImpl;
import com.pvt.dto.UsersDto;
import com.pvt.entities.User;
import com.pvt.services.ServiceException;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService<User>  {

    @Autowired
    UserDao userDao;

    @Override
    public User getByLogin(String login) {
        try {
            return (User) userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by login" + login);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return userDao.getAll();
        } catch (SQLException e) {
            throw new ServiceException("Error getting Users");
        }
    }

    @Override
    public List<UsersDto> getAllDto() {
        try {
            return userDao.getAllDto();
        } catch (SQLException e) {
            throw new ServiceException("Error getting Users");
        }
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User get(Serializable id) {
        return (User) userDao.get(id);
    }

    @Override
    public void deleteId(Serializable id) {
        userDao.delete(id);
    }
}
