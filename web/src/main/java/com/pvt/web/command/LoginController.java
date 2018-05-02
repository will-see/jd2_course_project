package com.pvt.web.command;


import com.pvt.entities.User;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new User());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") User userLogin) {
        ModelAndView mav = null;
        User user = (User)userService.getByLogin(userLogin.getLogin());
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("name", user.getName());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }

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
        //fillModel(model);
        //model.addAttribute("user", getPrincipal());
        return "welcome";
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

//    @Override
//    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        if (login==null || password==null) {
//            resp.setHeader("errorMsg", "Invalid Login or Password");
//            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            dispatcher.forward(req, resp);
//            return;
//        }
//        User user = userService.getByLogin(login);
//        if (user != null && user.getPassword().equals(Encoder.encode(password))) {
////        if (user != null && password.equals(user.getPassword())) {
//            req.getSession().setAttribute("user", user);
//            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath+ "/frontController?command=orders");
//            return;
//        } else {
//            req.setAttribute("errorMsg", "Invalid Login or Password");
//            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Login form");
//            dispatcher.forward(req, resp);
//            return;
//        }
//    }
}
