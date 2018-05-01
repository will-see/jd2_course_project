package com.pvt.web.command;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {


    @RequestMapping(value = "/login")
    public String loginPage() {

        return "loginPage";
    }

    @RequestMapping(value = "/reg")
    public String regPage() {
        return "regPage";
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(ModelAndView mav) {
        return mav;
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
