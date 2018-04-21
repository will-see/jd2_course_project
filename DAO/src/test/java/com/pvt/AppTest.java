package com.pvt;

import com.pvt.DAO.AuthorDao;
import com.pvt.DAO.BookDao;
import com.pvt.DAO.UserDao;
import com.pvt.DAO.impl.AuthorDaoImpl;
import com.pvt.DAO.impl.BookDaoImpl;
import com.pvt.DAO.impl.UserDaoImpl;
import com.pvt.dto.BookDto;
import com.pvt.entities.Author;
import com.pvt.entities.Book;
import com.pvt.entities.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Create the test case
     *
     */
    @Test
    public void Tests() {
        User user = new User();
        System.out.println(user);
    }
    @Test
    public void TestDAO()throws SQLException{
        BookDao bookDao = BookDaoImpl.getInstance();
        bookDao.openEmTransact();
//        bookDao.save(new Book("name","ganr",100,new Author(null,"name",1900,"country",null),10));
//        bookDao.save(new Book("name","ganr",100,new Author(),10));
        List<BookDto> list = bookDao.getAll();
        System.out.println(list);
        bookDao.closeEmTransact();
//        Assert.assertNotEquals(list.size(),0);
    }
    @Test
    public void TestDaoGetById()throws SQLException{
        BookDao bookDao = BookDaoImpl.getInstance();
        bookDao.openEmTransact();
//        bookDao.save(new Book("name","ganr",100,new Author(null,"name",1900,"country",null),10));
//        bookDao.save(new Book("name","ganr",100,new Author(),10));
        Book book = bookDao.get(4L);
        System.out.println(book.getTitle());
        bookDao.closeEmTransact();
//        Assert.assertNotEquals(list.size(),0);
    }
    @Test
    public void TestAuthorDAO()throws SQLException{
        AuthorDao authorDao = AuthorDaoImpl.getInstance();
        authorDao.openEmTransact();
        authorDao.save(new Author(null,"name",1900,"country",null));
//        List<BookDto> list = bookDao.getAll();
        authorDao.closeEmTransact();
//        Assert.assertNotEquals(list.size(),0);
    }

}
