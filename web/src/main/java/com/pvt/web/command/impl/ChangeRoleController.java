package com.pvt.web.command.impl;

import com.pvt.services.UserService;
import com.pvt.services.impl.UserServiceImpl;
import com.pvt.web.command.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeRoleController implements Controller {
    @Autowired
    UserService userService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("userId");
        String role = req.getParameter("role");
//        User user;
//        userService.get(Long.parseLong(id));
//        int role = user.getRole();
    }
}

