package com.pvt.web.command;

import com.pvt.entities.Book;
import com.pvt.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by yslabko on 019 19.09.16.
 */
@Controller
@RequestMapping("/products")
public class BookController {

    public static final String MAIN = "bookss/main";

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getBooks(ModelMap map) {
        fillModel(map);
        return MAIN;
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String processFile(MultipartFile file) {
        return MAIN;
    }

//    @RequestMapping(value = "/addBooks", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    public void addProduct(Book book, ModelMap map,
//                           @RequestParam(value="avatar", required=false) MultipartFile image) {
//        book = bookService.add(book);
//        try {
//            if (image != null && !image.isEmpty()) {
//                validateImage(image);
//                saveImage(book.getBookId() + ".jpg", image);
//            }
//        } catch (IOException e) {
//            //Error handling
//        } finally {
//            fillModel(map);
//        }
//    }

    private void validateImage(MultipartFile image) throws IOException {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new IOException("Only JPG images accepted");
        }
    }
    private void saveImage(String filename, MultipartFile image) throws IOException {
        File file = new File("/resources/" + filename);
//        FileUtils.writeByteArrayToFile(file, image.getBytes());
    }

    private void fillModel(ModelMap model) {
        populatePageName(model);
        model.addAttribute("product", new Book());
        model.addAttribute("products", bookService.getAll());
    }

    private void populatePageName(ModelMap model) {
        model.addAttribute("currentPageName", "products");
    }
}
