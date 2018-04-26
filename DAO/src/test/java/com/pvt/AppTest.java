package com.pvt;

import com.pvt.DAO.AuthorDao;
import com.pvt.DAO.BookDao;
import com.pvt.DAO.UserDao;
import com.pvt.DAO.impl.AuthorDaoImpl;
import com.pvt.DAO.impl.BookDaoImpl;
import com.pvt.DAO.impl.UserDaoImpl;
import com.pvt.dto.BookDto;
import com.pvt.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Unit test for simple App.
 */
@ContextConfiguration("/testContext.xml")

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
//@Commit
public class AppTest {
    /**
     * Create the test case
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;

    @Test
    public void EntityTest() {
        Author author = new Author();
        Book book = new Book();
        Formular formular = new Formular();
        Item item = new Item();
        Role role = new Role();
        User user = new User();

        author.setName("Pushkin");
        book.setTitle("Lukomor'e");
        book.setAuthor(author);
        System.out.println(book.getAuthor().getName());
//        bookDao.add(book);
//        author.setBooks(book);
//        user.setName("Petia");
//        user.setFormulars(new ArrayList<>());
//        user.getFormulars().add(formular);
//        Book persistent = (Book) bookDao.add(book);
        bookDao.add(new Book("lukomore","skazka",100, author,10));
//        Assert.assertNotEquals(user,null);

//        System.out.println(user);
//        System.out.println(formular);
    }

    @Test
    public void addUser() throws SQLException {
        User user = new User();
        user.setName("TestUser");
        user.setAge(30);
        user.setLogin("TestLogin");
        User persistent = (User) userDao.add(user);
        assertNotNull(persistent.getUserId());
        persistent = (User) userDao.get(persistent.getUserId());
        assertEquals("User not persist", user, persistent);
        List<User> allUsers = userDao.getAll();

        for (User allUser : allUsers) {
            System.out.println(allUser);
        }
        System.out.println(userDao.getByLogin("TestLogin"));
        userDao.delete(persistent.getUserId());
    }

    @Test
    public void tempTest() throws SQLException {
        userDao.delete(11l);
        System.out.println(userDao.getAll());
    }
}
