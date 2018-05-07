package com.pvt.DAO.impl;

import com.pvt.DAO.BookDao;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl extends BaseDao<Book> implements BookDao<Book> {

    public BookDaoImpl(){
        super();
        clazz = Book.class;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        Query query = getEm().createQuery("from Book ");
        return (List<Book>) query.getResultList();
    }
    @Override
    @SuppressWarnings("all")
    public List<BookDto> getAllDto() throws SQLException {
        EntityManager em = getEm();
        Session unwrap = em.unwrap(Session.class);
        List<BookDto> bookDto = unwrap.createSQLQuery("SELECT bookId, title, ganr,pages, a.name as author, bookCount FROM books b JOIN authors a ON b.AUTHOR_ID = a.authorId order by bookId;")
                .addScalar("bookId", StandardBasicTypes.LONG)
                .addScalar("title", StandardBasicTypes.STRING)
                .addScalar("ganr", StandardBasicTypes.STRING)
                .addScalar("pages", StandardBasicTypes.INTEGER)
                .addScalar("author", StandardBasicTypes.STRING)
                .addScalar("bookCount", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.aliasToBean(BookDto.class))
                .list();
        return bookDto;
    }
}
