package com.pvt;

import com.pvt.DAO.BookDao;
import com.pvt.DAO.impl.BookDaoImpl;
import com.pvt.entities.Author;
import com.pvt.entities.User;
import com.pvt.services.AuthorService;
import com.pvt.services.BookService;
import com.pvt.services.UserService;
import com.pvt.services.impl.AuthorServiceImpl;
import com.pvt.services.impl.BookServiceImpl;
import com.pvt.services.impl.UserServiceImpl;
import org.junit.Test;

import java.awt.print.Book;
import java.sql.SQLException;
//
///**
// * Unit test for simple App.
// */
public class ServAppTest {
    /**
     * Create the test case
     */
    @Test
    public void serviceTest() throws SQLException {
        BookService bookService = BookServiceImpl.getInstance();
        BookDao bookDao = BookDaoImpl.getInstance();
//        AuthorService authorService = AuthorServiceImpl.getInstance();
//        System.out.println("fake test");
        bookDao.openEmTransact();
        System.out.println(bookService.getAll());

        System.out.println(bookService.get(4l).getTitle());
        bookDao.closeEmTransact();
//        System.out.println(authorService.getAll());
    }
}
