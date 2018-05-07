package com.pvt.web.command;

import com.pvt.dto.BookDto;
import com.pvt.dto.UsersDto;
import com.pvt.entities.Role;
import com.pvt.entities.User;
import com.pvt.services.BookService;
import com.pvt.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

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

//    @Transactional
    @RequestMapping(value = "/changeRole", method = {RequestMethod.GET, RequestMethod.POST})
//    public String changeRole(HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");

        public String getUserIdFromJsp(ModelMap map,
                @RequestParam(defaultValue = "") String userId) {
//            if (StringUtils.isBlank(userId)) {
//                fillModel(map);
//            } else {
//                globalUserId = userId;
//                fillModel(map);

        User user =(User) userService.get(Long.parseLong(userId));
        Role role = user.getRole();
        if (role.getRoleName().equals("user")) {
            role.setRoleName("admin");
            user.setRole(role);
        }else{
            role.setRoleName("user");
            user.setRole(role);
        }
        userService.update(user);
//    }
        return "redirect:/users/page";
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
