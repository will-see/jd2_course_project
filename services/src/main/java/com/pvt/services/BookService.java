package com.pvt.services;

import com.pvt.dto.BookDto;
import com.pvt.entities.Book;

import java.util.List;

public interface BookService extends Service<Book> {

    void updateCount(long bookId, int bookCount);
    List<Book> getAll();
    List<BookDto> getAllDto();
}
