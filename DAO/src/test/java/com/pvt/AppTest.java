package com.pvt;

import com.pvt.DAO.UserDao;
import com.pvt.DAO.impl.UserDaoImpl;
import com.pvt.entities.User;
import org.junit.Test;

import java.sql.SQLException;
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
    public void rbTest() {
        Locale locale = new Locale("en");
        ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("login.login"));
        System.out.println(rb.getString("login.register"));
    }

    @Test
    public void daoTest() throws SQLException {
        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.get(2l);
        System.out.println(user);
//        user.setRole("0");
//        user.setRole("1");
//        System.out.println(user);
//        userDao.update(user);
    }
}
