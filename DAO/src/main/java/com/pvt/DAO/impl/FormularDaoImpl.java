package com.pvt.DAO.impl;

import com.pvt.DAO.FormularDao;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FormularDaoImpl extends BaseDao<Formular> implements FormularDao<Formular> {


//    private static final String getQuery = "SELECT formularId, userId, bookId FROM formular WHERE userId=?";
//    private static final String getUserFormularQuery = "SELECT books.name, authors.author_name FROM books JOIN formular on formular.bookId=books.bookId JOIN authors ON books.authorId = id_author WHERE userId=?";
//    private static final String getAllByUserQuery = "SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC";

    public FormularDaoImpl(){
        super();
        clazz = Formular.class;
    }

    @Override
    public List<FormularDto> getUserFormular(long userId) throws SQLException {
        Query query = getEm().createNativeQuery("SELECT books.name, authors.name FROM books JOIN formular on formular.bookId=books.bookId JOIN authors ON books.authorId = id_author WHERE userId=?");
        return query.getResultList();
    }
    @Override
    public List<Formular> getByUserId(long userId) throws SQLException {
        Query query = getEm().createNativeQuery("SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC");
//        Query query = getEm().createNativeQuery("formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC");
        return query.getResultList();
    }
}
