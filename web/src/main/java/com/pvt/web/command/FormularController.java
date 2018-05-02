package com.pvt.web.command;

import com.pvt.dto.BookDto;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;
import com.pvt.entities.User;
import com.pvt.services.BookService;
import com.pvt.services.FormularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by w510 on 019 19.09.16.
 */
@Controller
@RequestMapping("/formulars")
public class FormularController {

    public static final String MAIN = "formulars/main";

    @Autowired
    private FormularService formularService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getBooks(ModelMap map) {
        fillModel(map);
        return MAIN;
    }

    private void fillModel(ModelMap model) {
        populatePageName(model);
        model.addAttribute("formular", new Formular());
//        model.addAttribute("formulars", formularService.getByUserId());
    }


    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "books");
    }
}
