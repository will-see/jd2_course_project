package com.pvt.web.command.impl;

import com.pvt.entities.Formular;
import com.pvt.entities.User;
import com.pvt.services.FormularService;
import com.pvt.services.impl.FormularServiceImpl;
import com.pvt.web.command.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormularController implements Controller {
    @Autowired
    FormularService formularService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<Formular> formular = formularService.getByUserId(user.getUserId());

        req.setAttribute("formular", formular);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}
