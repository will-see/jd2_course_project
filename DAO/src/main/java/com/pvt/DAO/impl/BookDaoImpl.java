package com.pvt.DAO.impl;

import com.pvt.DAO.BookDao;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
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
public class BookDaoImpl extends BaseDao<Book> implements BookDao<Book> {

    public BookDaoImpl(){
        super();
        clazz = Book.class;
    }

    @Override
    public void updateCount(long bookId, int bookCount) throws SQLException {
        getEm().merge(bookCount);
    }

    @Override
    public List<Book> getAll() throws SQLException {
        Query query = getEm().createQuery("from Book ");
        return (List<Book>) query.getResultList();
    }

    @Override
    public List<BookDto> getAllDto() throws SQLException {
        Query query = getEm().createNativeQuery("SELECT bookId, b.title, ganr,pages, a.name, bookCount FROM books b JOIN authors a ON b.AUTHOR_ID = a.authorId order by bookId;");
        return query.getResultList();
    }
}
