package com.pvt.web.command;

import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
import com.pvt.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by w510 on 019 19.09.16.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    public static final String MAIN = "books/main";

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getBooks(ModelMap map) {
        fillModel(map);
        return MAIN;
    }

    private void fillModel(ModelMap model) {
        populatePageName(model);
        model.addAttribute("book", new BookDto());
        model.addAttribute("books", bookService.getAllDto());
    }


    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "books");
    }
}
