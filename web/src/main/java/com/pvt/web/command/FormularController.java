package com.pvt.web.command;

import com.pvt.dto.BookDto;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;
import com.pvt.entities.User;
import com.pvt.services.BookService;
import com.pvt.services.FormularService;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/formular")
public class FormularController {

//    long userId;

    public static final String MAIN = "formular/main";

    @Autowired
    private FormularService formularService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getBooks(ModelMap map) {
        fillModel(map);
        return MAIN;
    }

    private void fillModel(ModelMap model) {
        populatePageName(model);
        long userId = getUserId();
        model.addAttribute("formular", new FormularDto());
        model.addAttribute("formularDto", formularService.getUserBooksInFormular(userId));
    }

    private long getUserId() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        User currentUser = (User)userService.getByLogin(userName);
        return currentUser.getUserId();
    }

    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "formular");
    }
}
