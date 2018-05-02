package com.pvt.DAO.impl;

import com.pvt.DAO.UserDao;
import com.pvt.dto.BookDto;
import com.pvt.dto.UsersDto;
import com.pvt.entities.User;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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

    public UserDaoImpl() {
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
    @SuppressWarnings("all")
    public List<UsersDto> getAllDto() throws SQLException {
        EntityManager em = getEm();
        Session unwrap = em.unwrap(Session.class);
        List<UsersDto> usersDto = unwrap.createSQLQuery("SELECT users.USER_ID as userId, FIRST_NAME as name, LOGIN as login, AGE as age, SEX as sex, roles.ROLE_NAME AS role, COUNT(bookId) AS booksGot FROM users  JOIN roles ON users.ROLE_ID = roles.ROLE_ID  LEFT JOIN formulars ON users.USER_ID = formulars.USER_ID GROUP BY FIRST_NAME ORDER BY userId;")
                .addScalar("userId", StandardBasicTypes.LONG)
                .addScalar("name", StandardBasicTypes.STRING)
                .addScalar("login", StandardBasicTypes.STRING)
                .addScalar("age", StandardBasicTypes.INTEGER)
                .addScalar("sex", StandardBasicTypes.STRING)
                .addScalar("role", StandardBasicTypes.STRING)
                .addScalar("booksGot", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.aliasToBean(UsersDto.class))
                .list();
        return usersDto;
    }

}