package com.pvt.services;

import com.pvt.dto.BookDto;

import java.util.List;

public interface BookService<T> extends Service<T> {

    void updateCount(long bookId, int bookCount);
    List<T> getAll();
    List<BookDto> getAllDto();
}
