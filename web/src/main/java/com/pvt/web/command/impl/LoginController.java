package com.pvt.web.command.impl;

import com.pvt.entities.User;
import com.pvt.services.UserService;
import com.pvt.services.impl.UserServiceImpl;
import com.pvt.web.command.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {
    @Autowired
    UserService userService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login==null || password==null) {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
        User user = (User)userService.getByLogin(login);
//        if (user != null && user.getPassword().equals(Encoder.encode(password))) {
        if (user != null && password.equals(user.getPassword())) {
            req.getSession().setAttribute("user", user);
            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath+ "/frontController?command=formular");
            resp.sendRedirect(contextPath+ "/frontController?command=books");
            return;
        } else {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            req.setAttribute("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
    }
}
