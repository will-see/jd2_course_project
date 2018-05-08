package com.pvt;

import com.pvt.entities.*;
import com.pvt.services.BookService;
import com.pvt.services.FormularService;
import com.pvt.services.ItemService;
import com.pvt.services.UserService;
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
import java.util.logging.SocketHandler;

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
    @Autowired
    ItemService itemService;

    @Test
    public void fillBaseTest() {
//            Author author = new Author(null,"Puskin",1900,"Rusia",null);
//            author.setName("Pushkin");
        bookService.add(new Book(null,"lukomore1", "skazka1", 101, new Author(null, "Puskin1", 1901, "Rusia", null), 10,null));
        bookService.add(new Book(null,"lukomore2", "skazka2", 102, new Author(null, "Puskin2", 1902, "Rusia", null), 10,null));
        bookService.add(new Book(null,"lukomore3", "skazka3", 103, new Author(null, "Puskin3", 1903, "Rusia", null), 10,null));
        bookService.add(new Book(null,"lukomore4", "skazka4", 104, new Author(null, "Puskin4", 1904, "Rusia", null), 10,null));
        bookService.add(new Book(null,"lukomore5", "skazka5", 105, new Author(null, "Puskin5", 1905, "Rusia", null), 10,null));
        bookService.add(new Book(null,"lukomore6", "skazka6", 106, new Author(null, "Puskin6", 19006, "Rusia", null), 10,null));
//        bookService.add(new Book("lukomore2", "skazka2", 101, new Author(null, "Puskin", 1800, "Rusia", null), 10));
//        bookService.add(new Book("lukomore3", "skazka3", 102, new Author(null, "Puskin", 1700, "Rusia", null), 10));
//        bookService.add(new Book("lukomore4", "skazka4", 103, new Author(null, "Puskin", 1600, "Rusia", null), 10));
//        bookService.add(new Book("lukomore5", "skazka5", 104, new Author(null, "Puskin", 1500, "Rusia", null), 10));
//        bookService.add(new Book("lukomore6", "skazka6", 105, new Author(null, "Puskin", 1400, "Rusia", null), 10));
//
//        Role role = new Role(null,  "admin", null);
        userService.add(new User(null,"admin","admin","admin",10,"male",new Role(null,  "admin", null),null));
        userService.add(new User(null,"admin2","admin2","admin2",20,"male",new Role(null,  "admin", null),null));
        userService.add(new User(null,"admin3","admin3","admin3",30,"male",new Role(null,  "admin", null),null));
        userService.add(new User(null,"user","user","user",40,"male",new Role(null,  "user", null),null));
        userService.add(new User(null,"user2","user2","user2",50,"male",new Role(null,  "user", null),null));
        userService.add(new User(null,"user3","user3","user3",60,"male",new Role(null,  "user", null),null));
    }

    @Test
    public void serviceTest() throws SQLException {
        System.out.println(userService.getAllDto());
    }
    @Test
    public void serviceFormularDtoTest() throws SQLException {
        System.out.println(formularService.getUserBooksInFormular(15l));
    }

    @Test
    public void getBookTest(){
        User user = (User)userService.get(2l);
        Book book = (Book) bookService.get(2l);

        Formular f = new Formular(null,user,new ArrayList<>());

        book.getFormulars().add(f);
        f.getBooks().add(book);

        formularService.add(f);
        bookService.add(book);
    }

    @Test
    public void getBooksList(){
        User user = (User)userService.get(13l);
        Book book = (Book) bookService.get(1l);
        List<Book> books = new ArrayList<>();
        Formular formular = new Formular(null,user,books);
        formularService.add(formular);
        Formular formularFromBase = (Formular)formularService.get(13l);
        Long userId = formularFromBase.getUser().getUserId();
        List<Book> list = formularFromBase.getBooks();
        System.out.println(userId);
        System.out.println(list);
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
    public void serviceItem() throws SQLException {
        Book book = (Book)bookService.get(1l);
        User user = (User) userService.get(13l);
        Formular formular = (Formular) formularService.get(13l);

//            Item tItem = new Item(null,new Formular(null,new User(null,"fake","fake","fake",100,"male",(new Role(null,"user",null)),null),null,null),book);

        Item item = new Item(null,formular,book);

        Author a = new Author(null,null,0,null,null);
        User u = new User(null,null,null,null,0,null,null,null);
        Book b = new Book(null,"title","ganr",0,a,50,null);
        Item fItem = new Item(null,null,b);

//        Formular f = new Formular(null,u,null,null);

            System.out.println(book);
            System.out.println(user);
            System.out.println(formular);
    }


    @Test
            public void newFormularTest() throws SQLException {

//        formularService.add(new Formular(null, new User(), null, 11l));
    }
}
