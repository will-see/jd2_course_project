package com.pvt.web.command;

import com.google.gson.Gson;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
import com.pvt.entities.Formular;
import com.pvt.entities.User;
import com.pvt.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by w510 on 019 19.09.16.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    public static final String MAIN = "books/main";

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private FormularService formularService;

    @RequestMapping(value = "/page", method = {RequestMethod.GET, RequestMethod.POST})
    public String allBooks(ModelMap map) {
        fillModel(map);

        return MAIN;
    }
    @Transactional
    @RequestMapping(value = "/getBook", method = {RequestMethod.POST})
    public String getBooks(HttpServletRequest request, ModelMap map) {

        long bookId = Long.parseLong(request.getParameter("bookId"));
        User currentUser = getUser();
        long userId = currentUser.getUserId();
        System.out.println("book id = " + bookId + " user id " + userId);

        Book book = bookService.get(bookId);
        int bookCount = book.getBookCount();

        if (bookCount > 0) {
            List<Formular> formulars = formularService.getByUserId(userId);
            ArrayList<Book> books = new ArrayList<>();
            if (formulars.size() == 0) {
                books.add(book);
                bookCount--;
                bookService.updateCount(bookId, bookCount);
                formularService.add(new Formular(null, currentUser, books));
//                formularService.add(new Formular(null, currentUser, new Item(null,null,book), bookId));
            } else {
                boolean flag = true;
                for (int i = 0; i < formulars.size(); i++) {
                    if (formulars.get(i).getBooks().contains(book)) {
                        flag = false;
                        break;
                    }
                    throw new ServiceException(" book taken yet ");
                }
                if (flag == true) {
                    bookCount--;
                    bookService.updateCount(bookId, bookCount);
                    books.add(book);
                }
            }
        }

        return "redirect:/books/page";
    }

//    private void addToFormular(){
//        User user = (User)userService.get(2l);
//        Book book = (Book) bookService.get(2l);
//
//        Formular f = new Formular(null,user,new ArrayList<>());
//
//        book.getFormulars().add(f);
//        f.getBooks().add(book);
//
//        formularService.add(f);
//        bookService.add(book);
//    }

    @RequestMapping(value = "/getBack", method = {RequestMethod.POST})
    public String getBack(HttpServletRequest request, ModelMap map) {

        long bookId = Long.parseLong(request.getParameter("bookId"));
        long userId = Long.parseLong(request.getParameter("userId"));
//        User currentUser = getUser();
//        long userId = currentUser.getUserId();
        System.out.println("book id = " + bookId + " user id " + userId);
        doGetBack(userId, bookId);
        return "redirect:/formular/page";
    }

    @Transactional
    void doGetBack(long bookId, long userId) {
        Formular formular = (Formular) formularService.getByUserId(userId);
        Book book = (Book) bookService.get(bookId);
//        if (formular.contains(book)){
//
//        }
    }

    private User getUser() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        User currentUser = (User) userService.getByLogin(userName);
        return currentUser;
    }

    private void fillModel(ModelMap model) {
        populatePageName(model);
        model.addAttribute("book", new BookDto());
        model.addAttribute("books", bookService.getAllDto());
    }


    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "books");
    }
}
