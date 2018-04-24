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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.sql.SQLException;
//
///**
// * Unit test for simple App.
// */
@ContextConfiguration("/testContext.xml")

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
public class ServAppTest {
    /**
     * Create the test case
     */
    @Autowired
    BookDao bookDao;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @Test
    public void serviceTest() throws SQLException {
        System.out.println(bookService.getAllDto());
//        System.out.println(userService.getAll());
//        userService.deleteId(11l);
//        System.out.println(userService.get(11l));
    }
}
