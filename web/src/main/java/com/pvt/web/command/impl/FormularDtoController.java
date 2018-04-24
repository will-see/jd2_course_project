package com.pvt.web.command.impl;

import com.pvt.dto.FormularDto;
import com.pvt.entities.User;
import com.pvt.services.FormularService;
import com.pvt.services.impl.FormularServiceImpl;
import com.pvt.web.command.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormularDtoController implements Controller {

    @Autowired
    FormularService formularService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String id = req.getParameter("userId");
        if (id!=null){
            List<FormularDto> formularDto = formularService.getUserFormular(Long.parseLong(id));
            req.setAttribute("formularDto", formularDto);
        }else {
            List<FormularDto> formularDto = formularService.getUserFormular(user.getUserId());
            req.setAttribute("formularDto", formularDto);
        }

//        req.setAttribute("formularDto", formularDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}
