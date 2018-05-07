package com.pvt;

import com.pvt.entities.*;
import com.pvt.services.BookService;
import com.pvt.services.FormularService;
import com.pvt.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

//
///**
// * Unit test for simple App.
// */
@ContextConfiguration("/testContext.xml")

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
@Commit
public class ServAppTest {
    /**
     * Create the test case
     */

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @Autowired
    FormularService formularService;

    @Test
    public void fillBaseTest() {
//            Author author = new Author(null,"Puskin",1900,"Rusia",null);
//            author.setName("Pushkin");
//        bookService.add(new Book("lukomore", "skazka", 100, new Author(null, "Puskin", 1900, "Rusia", null), 10));
//        bookService.add(new Book("lukomore2", "skazka2", 101, new Author(null, "Puskin", 1800, "Rusia", null), 10));
//        bookService.add(new Book("lukomore3", "skazka3", 102, new Author(null, "Puskin", 1700, "Rusia", null), 10));
//        bookService.add(new Book("lukomore4", "skazka4", 103, new Author(null, "Puskin", 1600, "Rusia", null), 10));
//        bookService.add(new Book("lukomore5", "skazka5", 104, new Author(null, "Puskin", 1500, "Rusia", null), 10));
//        bookService.add(new Book("lukomore6", "skazka6", 105, new Author(null, "Puskin", 1400, "Rusia", null), 10));
//
//        Role role = new Role(null,  "admin", null);
        userService.add(new User(null,"admin","admin","admin",10,"male",new Role(null,  "admin", null),null));
        userService.add(new User(null,"admin2","admin2","admin2",20,"male",new Role(null,  "admin", null),null));
        userService.add(new User(null,"admin","admin","admin",30,"male",new Role(null,  "admin", null),null));
        userService.add(new User(null,"user","user","user",40,"male",new Role(null,  "user", null),null));
        userService.add(new User(null,"user2","user2","user2",50,"male",new Role(null,  "user", null),null));
        userService.add(new User(null,"user3","user3","user3",60,"male",new Role(null,  "user", null),null));
    }

    @Test
    public void serviceTest() throws SQLException {
        System.out.println(bookService.getAllDto());
    }
    @Test
    public void serviceFormularDtoTest() throws SQLException {
        System.out.println(formularService.getUserBooksInFormular(15l));
    }


    @Test
    public void boksUpdateCountTest() throws SQLException{
        bookService.updateCount(11l,9);
    }

    @Test
    public void serviceFormularId() throws SQLException {
        System.out.println(formularService.getByUserId(21l));
    }
    @Test
            public void newFormularTest() throws SQLException {

        formularService.add(new Formular(null, new User(), null, 11l));
    }
}
