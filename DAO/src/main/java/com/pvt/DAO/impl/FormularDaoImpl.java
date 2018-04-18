package com.pvt.DAO.impl;

import com.pvt.DAO.FormularDao;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FormularDaoImpl extends AbstractDao implements FormularDao {
    private static volatile FormularDao INSTANCE = null;

    public static FormularDao getInstance() {
        FormularDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (BookDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new FormularDaoImpl();
                }
            }
        }
        return productDao;
    }

    private static final String getQuery = "SELECT formularId, userId, bookId FROM formular WHERE userId=?";
    private static final String getUserFormularQuery = "SELECT books.name, authors.author_name FROM books JOIN formular on formular.bookId=books.bookId JOIN authors ON books.authorId = id_author WHERE userId=?";
    private static final String getAllByUserQuery = "SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC";

    @Override
    public Formular save(Formular formular) throws SQLException {
        getEm().persist(formular);
        return formular;
    }

    @Override
    public Formular get(Serializable id) throws SQLException {
        return getEm().find(Formular.class, id);
    }

    @Override
    public void update(Formular formular) throws SQLException {
        getEm().merge(formular);
    }

    @Override
    public void delete(Formular formular) throws SQLException {
        getEm().remove(formular);
    }

    @Override
    public List<FormularDto> getUserFormular(long userId) throws SQLException {
        Query query = getEm().createNativeQuery("SELECT books.name, authors.name FROM books JOIN formular on formular.bookId=books.bookId JOIN authors ON books.authorId = id_author WHERE userId=?");
        return query.getResultList();
    }
    @Override
    public List<Formular> getByUserId(long userId) throws SQLException {
        Query query = getEm().createNativeQuery("SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC");
        return query.getResultList();
    }
}
