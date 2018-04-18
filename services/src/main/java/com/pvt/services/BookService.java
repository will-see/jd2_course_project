package com.pvt.services;

import com.pvt.dto.BookDto;
import com.pvt.entities.Book;

import java.io.Serializable;
import java.util.List;

public interface BookService {
    Book createBook(String name, String ganr, int pages, long author, int bookCount);
    Book get(Serializable id);
    void update(Book book);
    void updateCount(long bookId, int bookCount);
    void delete(Book book);
//    Book getByNameAndGanr(String name, String ganr);
    List<BookDto> getAll();
}
