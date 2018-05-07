package com.pvt.web.command;

import com.google.gson.Gson;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;
import com.pvt.entities.Formular;
import com.pvt.entities.Item;
import com.pvt.entities.User;
import com.pvt.services.BookService;
import com.pvt.services.FormularService;
import com.pvt.services.ServiceException;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
            if (formulars.size() == 0) {
                bookCount--;
                bookService.updateCount(bookId, bookCount);
                formularService.add(new Formular(null, currentUser, null, bookId));
//                formularService.add(new Formular(null, currentUser, new Item(null,null,book), bookId));
            } else {
                boolean flag = true;
                for (int i = 0; i < formulars.size(); i++) {
                    if (formulars.get(i).getBookId() == bookId) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    bookCount--;
                    bookService.updateCount(bookId, bookCount);
                    formularService.add(new Formular(null, currentUser, null, bookId));
//                    throw new ServiceException(" book taken yet ");
                }
            }
        }

        return "redirect:/books/page";
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

//    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
//    public void booksPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        User user = (User) request.getSession().getAttribute("user");
//        long bookId = Long.parseLong(request.getParameter("bookId"));
//        long userId = user.getUserId();
//
////        Book book = bookService.get(bookId);
//        System.out.println("it works");
////        bookService.updateCount(bookId, 1000);
//
//        PrintWriter writer = null;
//        writer = response.getWriter();
//        writer.print(new Gson().toJson(10000));
//    }

//    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
//    public @ResponseBody
//    Book getBook(@RequestParam String bookId) {
//
//        Book result = new Book();
//        System.out.println("test boton");
//        if (text != null) {
//            result.setText(text);
//            result.setCount(text.length());
//        }

//        return result;
//    }


    private void fillModel(ModelMap model) {
        populatePageName(model);
        model.addAttribute("book", new BookDto());
        model.addAttribute("books", bookService.getAllDto());
    }


    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "books");
    }
}
