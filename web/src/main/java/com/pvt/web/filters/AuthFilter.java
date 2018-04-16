package com.pvt.web.filters;

import com.pvt.web.command.enums.ControllerType;
import com.pvt.web.handlers.RequestHandler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.pvt.web.command.enums.ControllerType.FORMULAR;


@WebFilter(urlPatterns = {"/frontController"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        ControllerType type = RequestHandler.getCommand(req);
        if (FORMULAR.equals(type)) {
            String contextPath = req.getContextPath();
            HttpSession session = req.getSession();
            if((session.getAttribute("user") == null)) {
                res.sendRedirect(contextPath + "/frontController?command=login");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}