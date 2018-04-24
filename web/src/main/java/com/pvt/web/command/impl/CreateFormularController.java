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

/**
 * Created by yslabko on 08/17/2017.
 */
public class CreateFormularController implements Controller {
    @Autowired
    FormularService formularService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        long bookId = (long)req.getAttribute("productId");
        // TODO: 23.04.2018   Formular formular = formularService.createFormular(user.getUserId(), bookId);

        // TODO: 23.04.2018  req.setAttribute("formular", formular);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}