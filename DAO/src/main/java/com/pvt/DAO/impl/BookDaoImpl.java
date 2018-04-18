package com.pvt.DAO.impl;

import com.pvt.DAO.BookDao;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends AbstractDao implements BookDao {
    private static volatile BookDao INSTANCE = null;


    public static BookDao getInstance() {
        BookDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (BookDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new BookDaoImpl();
                }
            }
        }
        return productDao;
    }


    @Override
    public Book save(Book product) throws SQLException {
        getEm().persist(product);
        return product;
    }

    @Override
    public Book get(Serializable id) throws SQLException {
        return getEm().find(Book.class, id);
    }

    @Override
    public void update(Book book) throws SQLException {
        getEm().merge(book);
    }

    @Override
    public void delete(Book book) throws SQLException {
        getEm().remove(book);
    }

    @Override
    public void updateCount(long bookId, int bookCount) throws SQLException {
        getEm().merge(bookCount);
    }

    @Override
    public List<BookDto> getAll() throws SQLException {
        Query query = getEm().createNativeQuery("SELECT bookId, b.name, ganr,pages, a.name, bookCount FROM books b JOIN authors a ON b.AUTHOR_ID = a.authorId order by bookId;");
        return query.getResultList();
    }
//
//    @Override
//    public List<BookDto> getAllDto() throws SQLException {
//        Query query = getEm().createNativeQuery("SELECT bookId, name, ganr,pages, authors.name, book_count FROM books JOIN authors a ON books.authorId = a.id_author order by bookId;");
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Book> getAll() throws SQLException {
//        Query query = getEm().createQuery("from Book");
//        return query.getResultList();
//    }
}
