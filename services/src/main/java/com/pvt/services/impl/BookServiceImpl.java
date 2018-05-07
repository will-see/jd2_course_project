package com.pvt.services.impl;

import com.pvt.DAO.BookDao;
import com.pvt.DAO.impl.BookDaoImpl;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
import com.pvt.services.BookService;
import com.pvt.services.ServiceException;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public Book get(Serializable id) {
            return (Book) bookDao.get(id);
    }

    @Override
    public void update(Book book) {
            bookDao.update(book);
    }

    @Override
    public void deleteId(Serializable id) {
            bookDao.delete(id);
    }

    @Override
    public void updateCount(long bookId, int bookCount) {
            Book book = (Book) bookDao.get(bookId);
            book.setBookCount(bookCount);
            bookDao.update(book);
    }

    @Override
    public List<Book> getAll() {
        try {
            List<Book> list = bookDao.getAll();
            return list;
        } catch (SQLException e) {
            throw new ServiceException("Error getting Books");
        }
    }

    @Override
    public List<BookDto> getAllDto() {
        try {
            List<BookDto> list = bookDao.getAllDto();
            return list;
        } catch (SQLException e) {
            throw new ServiceException("Error getting Books");
        }
    }
}
