package com.pvt.web.command.impl;

import com.pvt.services.BookService;
import com.pvt.services.impl.BookServiceImpl;
import com.pvt.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("books", bookService.getAll());
//        req.getSession().setAttribute("counter", 2);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
