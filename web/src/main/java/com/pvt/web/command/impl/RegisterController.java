package com.pvt.web.command.impl;

import com.pvt.entities.User;
import com.pvt.services.UserService;
import com.pvt.services.impl.UserServiceImpl;
import com.pvt.web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController implements Controller {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");

        if (login == null || password == null || name == null || age == null || sex == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Register form");
            dispatcher.forward(req, resp);
            return;
        }

        if (login != null || password != null || name != null || age != null || sex != null) {
        int intAge = Integer.parseInt(age);
            User user = userService.create(name, login, password, intAge, sex);
//        if (user != null && user.getPassword().equals(Encoder.encode(password))) {
//        if (user != null && password.equals(user.getPassword())) {
//            req.getSession().setAttribute("user", user);
//            String contextPath = req.getContextPath();
//
//            resp.sendRedirect(contextPath+ "/frontController?command=formular");
//            login = null;
//            password = null;
//            req.getSession().invalidate();
//        resp.sendRedirect("/frontController?command=formular");
        req.getServletContext().getRequestDispatcher("/frontController?command=login").forward(req, resp);
        return;
//        } else {
//            req.setAttribute("errorMsg", "login exist yet");
//            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Register form");
//            dispatcher.forward(req, resp);
//            return;
        }
    }
}
