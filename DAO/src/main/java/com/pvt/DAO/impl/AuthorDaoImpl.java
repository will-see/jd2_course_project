package com.pvt.DAO.impl;

import com.pvt.DAO.AuthorDao;
import com.pvt.entities.Author;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl extends AbstractDao implements AuthorDao {
    private static volatile AuthorDao INSTANCE = null;


    public static AuthorDao getInstance() {
        AuthorDao authorDao = INSTANCE;
        if (authorDao == null) {
            synchronized (BookDaoImpl.class) {
                authorDao = INSTANCE;
                if (authorDao == null) {
                    INSTANCE = authorDao = new AuthorDaoImpl();
                }
            }
        }
        return authorDao;
    }


    @Override
    public Author save(Author author) throws SQLException {
        getEm().persist(author);
        return author;
    }

    @Override
    public Author get(Serializable id) throws SQLException {
        return getEm().find(Author.class,id);
    }

    @Override
    public void update(Author author) throws SQLException {
        getEm().merge(author);
    }

    @Override
    public void delete(Author author) throws SQLException {
        getEm().remove(author);
    }

    @Override
    public List<Author> getAll() throws SQLException {
        Query query = getEm().createQuery("from Author");
        return query.getResultList();
    }

    @Override
    public Author getByName(String name) throws SQLException {
        Query query = getEm().createQuery("from Author where name=?");
        return null;
    }

}
