package com.pvt.web.command;


import com.pvt.entities.User;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
//        fillModel(model);
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
//        ModelAndView mav = new ModelAndView("login");
//        mav.addObject("login", new User());
//        return mav;
//    }

//    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
//                                     @ModelAttribute("login") User userLogin) {
//        ModelAndView mav = null;
//        User user = (User) userService.getByLogin(userLogin.getLogin());
//        if (null != user) {
//            mav = new ModelAndView("welcome");
//            mav.addObject("name", user.getName());
//        } else {
//            mav = new ModelAndView("login");
//            mav.addObject("message", "Username or Password is wrong!!");
//        }
//        return mav;
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") User user) {
        userService.add(user);
        return new ModelAndView("welcome", "name", user.getName());
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
//        fillModel(model);
        model.addAttribute("user", getPrincipal());
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

//    private void fillModel(ModelMap model) {
//        populatePageName(model);
//        model.addAttribute("user", new User());
//        model.addAttribute("users", userService.getAll());
//    }

//    private void populatePageName(ModelMap model) {
//        model.addAttribute("currentPageName", "users");
//    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}
