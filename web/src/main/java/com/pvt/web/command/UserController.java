package com.pvt.web.command;

import com.pvt.dto.BookDto;
import com.pvt.dto.UsersDto;
import com.pvt.entities.User;
import com.pvt.services.BookService;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by w510 on 019 19.09.16.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    public static final String MAIN = "users/main";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getUsers(ModelMap map) {
        fillModel(map);
        return MAIN;
    }

    private void fillModel(ModelMap model) {
        populatePageName(model);
        model.addAttribute("user", new UsersDto());
        model.addAttribute("users", userService.getAllDto());
    }


    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "books");
    }
}
