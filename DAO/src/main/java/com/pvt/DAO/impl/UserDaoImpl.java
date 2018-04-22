package com.pvt.DAO.impl;

import com.pvt.DAO.UserDao;
import com.pvt.dto.UsersDto;
import com.pvt.entities.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao<User> {

    public UserDaoImpl(){
        super();
        clazz = User.class;
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.where(cb.equal(userRoot.get("login"), login));
//        Query query = getEm().createQuery("from User where login = : login");
//        return (User) query.getResultList().get(0);
        try {
            return getEm().createQuery(criteria).getResultList().get(0);
        } catch (IndexOutOfBoundsException sss) {
            return null;
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        Query query = getEm().createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    public List<UsersDto> getAllDto() throws SQLException {
        Query query = getEm().createNativeQuery("SELECT users.userId, name, login,age, sex,role, count(bookId)\n" +
                "FROM users JOIN roles ON users.id_role = roles.id_role\n" +
                "LEFT JOIN formular ON users.userId = formular.userId\n" +
                "GROUP BY NAME\n" +
                "ORDER BY users.userId;");
        return (List<UsersDto>) query.getResultList();
    }
}