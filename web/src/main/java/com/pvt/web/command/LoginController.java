package com.pvt.web.command;


import com.pvt.entities.Role;
import com.pvt.entities.User;
import com.pvt.services.ServiceException;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        return "login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setRole(new Role(null,"user",null));
        user.setPassword(encoder.encode(user.getPassword()));
        userService.add(user);
        return new ModelAndView("login", "name", user.getName());
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String loginFailed(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("message", "Invalid Login or Password");
        return "login";
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("errors/403");
        return model;

    }

//    private void fillModel(ModelMap model) {
//        populatePageName(model);
//        model.addAttribute("user", new User());
//        model.addAttribute("users", userService.getAll());
//    }

//    private void populatePageName(ModelMap model) {
//        model.addAttribute("currentPageName", "users");
//    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}
