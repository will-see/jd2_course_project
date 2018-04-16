package com.pvt.DAO.impl;

import com.pvt.DAO.UserDao;
import com.pvt.dto.UsersDto;
import com.pvt.entities.User;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private static volatile UserDao INSTANCE = null;

    private static final String saveUserQuery = "INSERT INTO users (name,LOGIN, password, age, sex) VALUES (?,?,?,?,?)";
    private static final String getUserQuery = "SELECT * FROM users WHERE login=?";
    private static final String getUserByIdQuery = "SELECT * FROM users WHERE userId=?";
    private static final String updateUserQuery = "UPDATE users SET id_role=? WHERE userId=?";
    private static final String deleteUserQuery = "DELETE FROM users WHERE userId=?";
    private static final String getAllUsersDto = "SELECT users.userId, name, login,age, sex,role, count(bookId)\n" +
            "FROM users JOIN roles ON users.id_role = roles.id_role\n" +
            "  LEFT JOIN formular ON users.userId = formular.userId\n" +
            "  GROUP BY name\n" +
            "ORDER BY users.userId;";
//    private static final String getUserByLoginQuery = "SELECT * FROM users WHERE LOGIN = ?";

    private PreparedStatement psSave;
    private PreparedStatement psGet;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    private PreparedStatement psGetByLogin;
    private PreparedStatement psGetAllDto;

    private UserDaoImpl() {
    }

    @Override
    public User save(User user) throws SQLException {
        psSave = prepareStatement(saveUserQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setString(1, user.getName());
        psSave.setString(2, user.getLogin());
        psSave.setString(3, user.getPassword());
        psSave.setInt(4, user.getAge());
        psSave.setString(5, user.getSex());
//        psSave.setInt(6, user.getRole());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            user.setUserId(rs.getLong(1));
        }
        close(rs);
        return user;
    }

    @Override
    public User get(Serializable userId) throws SQLException {
        psGet = prepareStatement(getUserByIdQuery);
        psGet.setLong(1, (long) userId);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateEntity(rs);
        }
        close(rs);

        return null;
    }


    @Override
    public void update(User user) throws SQLException {
        psUpdate = prepareStatement(updateUserQuery);
        psUpdate.setLong(2, user.getUserId());
//        psUpdate.setString(1, user.getName());
//        psUpdate.setString(2, user.getLogin());
//        psUpdate.setString(3, user.getPassword());
//        psUpdate.setInt(4, user.getAge());
//        psUpdate.setString(5, user.getSex());
        psUpdate.setString(1, user.getRole());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable userId) throws SQLException {
        psDelete = prepareStatement(deleteUserQuery);
        psDelete.setLong(1, (long) userId);
        return psDelete.executeUpdate();
    }


    @Override
    public User getByLogin(String login) throws SQLException {
        psGetByLogin = prepareStatement(getUserQuery);
        psGetByLogin.setString(1, login);
        ResultSet rs = psGetByLogin.executeQuery();
        if (rs.next()) {
            return populateEntity(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public List<UsersDto> getAll() throws SQLException {
        psGetAllDto = prepareStatement(getAllUsersDto);
        psGetAllDto.execute();
        ResultSet rs = psGetAllDto.getResultSet();
        List<UsersDto> list = new ArrayList<>();
        while (rs.next()) {
            list.add(populateUsersDto(rs));
        }
        close(rs);
        return list;
    }

    private User populateEntity(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getLong(1));
        user.setName(rs.getString(2));
        user.setLogin(rs.getString(3));
        user.setPassword(rs.getString(4));
        user.setAge(rs.getInt(5));
        user.setSex(rs.getString(6));
        user.setRole(rs.getString(7));
        return user;
    }

    private UsersDto populateUsersDto(ResultSet rs) throws SQLException {
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId(rs.getLong(1));
        usersDto.setName(rs.getString(2));
        usersDto.setLogin(rs.getString(3));
        usersDto.setAge(rs.getInt(4));
        usersDto.setSex(rs.getString(5));
        usersDto.setRole(rs.getString(6));
        usersDto.setBooksGot(rs.getInt(7));
        return usersDto;
    }

    public static UserDao getInstance() {
        UserDao userDao = INSTANCE;
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                userDao = INSTANCE;
                if (userDao == null) {
                    INSTANCE = userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }
}
