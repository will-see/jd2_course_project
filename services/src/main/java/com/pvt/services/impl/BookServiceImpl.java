package com.pvt.services.impl;

import com.pvt.DAO.BookDao;
import com.pvt.DAO.impl.BookDaoImpl;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
import com.pvt.services.BookService;
import com.pvt.services.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl extends AbstractService implements BookService {
    private static volatile BookServiceImpl INSTANCE = null;

    BookDao bookDao = BookDaoImpl.getInstance();


    @Override
    public Book createBook(String title, String ganr, int pages, long author, int bookCount) {
        Book book = new Book();
        try {
            startTransaction();
            book.setTitle(title);
            book = bookDao.save(book);
            commit();
            return book;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Book" + book);
        }
    }

    @Override
    public Book get(Serializable id) {
        try {
            return bookDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Book by id" + id);
        }
    }

    @Override
    public void update(Book book) {
        try {
            bookDao.update(book);
        } catch (SQLException e) {
            throw new ServiceException("Error updating Book" + book);
        }
    }

    @Override
    public void updateCount(long bookId, int bookCount) {
        try {
            bookDao.updateCount(bookId,bookCount);
        } catch (SQLException e) {
            throw new ServiceException("Error updating Book count" + bookCount);
        }
    }

    @Override
    public void delete(Book book) {
        try {
            bookDao.delete(book);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting Book by id" + book);
        }
    }

//    @Override
//    public Book getByNameAndGanr(String name, String ganr) {
//        try {
//            return bookDao.getByNameAndGanr(name, ganr);
//        } catch (SQLException e) {
//            throw new ServiceException("Error getting by BookGanr:" + ganr + " and bookName:" + name);
//        }
//    }

    @Override
    public List<BookDto> getAll() {
        try {
            bookDao.openEmTransact();
            List<BookDto> list = bookDao.getAll();
            bookDao.closeEmTransact();
            return list;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Books");
        }
    }

    public static BookServiceImpl getInstance() {
        BookServiceImpl bookServiceImpl = INSTANCE;
        if (bookServiceImpl == null) {
            synchronized (BookServiceImpl.class) {
                bookServiceImpl = INSTANCE;
                if (bookServiceImpl == null) {
                    INSTANCE = bookServiceImpl = new BookServiceImpl();
                }
            }
        }
        return bookServiceImpl;
    }
}
