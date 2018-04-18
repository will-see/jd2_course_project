package com.pvt.services.impl;

import com.pvt.DAO.UserDao;
import com.pvt.DAO.impl.UserDaoImpl;
import com.pvt.dto.UsersDto;
import com.pvt.entities.User;
import com.pvt.services.ServiceException;
import com.pvt.services.UserService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends AbstractService implements UserService {
    private static volatile UserService INSTANCE = null;
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public User createUser(String name, String login, String password, int age, String sex) {
        User user = new User();
        try {
            startTransaction();
            user.setName(name);
            user.setLogin(login);
            user.setPassword(password);
            user.setAge(age);
            user.setSex(sex);
            user = userDao.save(user);
            commit();
            return user;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating User" + user);
        }
    }

    @Override
    public User get(Serializable id) {
        try {
            return userDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by id" + id);
        }
    }

    @Override
    public void update(User user) {
        try {
            userDao.update(user);
        } catch (SQLException e) {
            throw new ServiceException("Error updating user book" + user);
        }
    }

    @Override
    public void delete(User user) {
        try {
            userDao.openEmTransact();
            userDao.delete(user);
            userDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error deleting User by id" + user);
        }
    }

    @Override
    public User getByLogin(String login) {
        try {
            return userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by login" + login);
        }
    }

    @Override
    public List<UsersDto> getAll() {
        try {
            return userDao.getAll();
        } catch (SQLException e) {
            throw new ServiceException("Error getting Users");
        }
    }

    public static UserService getInstance() {
        UserService userService = INSTANCE;
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                userService = INSTANCE;
                if (userService == null) {
                    INSTANCE = userService = new UserServiceImpl();
                }
            }
        }

        return userService;
    }
}
