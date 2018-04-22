package com.pvt.DAO.impl;

import com.pvt.DAO.AuthorDao;
import com.pvt.entities.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AuthorDaoImpl extends BaseDao<Author> implements AuthorDao<Author> {

    public AuthorDaoImpl(){
        super();
        clazz = Author.class;
    }

    @Override
    public List<Author> getAll() throws SQLException {
        Query query = getEm().createQuery("from Author");
        return query.getResultList();
    }

    @Override
    public Author getByName(String name) throws SQLException {
        Query query = getEm().createQuery("from Author where name=?");
        return (Author) query.getSingleResult();
    }

}
