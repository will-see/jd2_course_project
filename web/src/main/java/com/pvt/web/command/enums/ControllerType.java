package com.pvt.web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.pvt.web.command.Controller;
import com.pvt.web.command.impl.*;

@Getter
@AllArgsConstructor
public enum ControllerType {
    LOGIN("login.jsp", "Login","login.title", new LoginController()),
    LOGOUT("login.jsp", "Logout", "logout.title",new LogoutController()),
    FORMULAR("formular/main.jsp", "Formular","formular.title", new FormularDtoController()),
    BOOKS("books/main.jsp", "Books", "books.title",new BookController()),
    REGISTER("register.jsp", "Register", "register.title", new RegisterController()),
    USERS("users/main.jsp", "Users", "users.title", new UsersController()),
//    VIEWFORMULAR("viewformular/main.jsp", "Viewformular", "formular.title", new ViewFormularController()),
//    CHANGE("change/main.jsp", "Change", "users.title", new ChangeRoleController()),
//    CHANGE("users/main.jsp", "Change", "users.title", new ChangeRoleController()),
    ADD_PRODUCTS_AJAX("", "GetBook", "", new GetBookController());

    private String pagePath;
    private String pageName;
    private String i18nKey;
    private Controller controller;

    public static ControllerType getByPageName(String page) {
        for (ControllerType type : ControllerType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с продуктами
        return BOOKS;
    }
}
