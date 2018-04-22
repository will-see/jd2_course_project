package com.pvt.DAO;

import com.pvt.dto.BookDto;
import com.pvt.entities.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao<T> extends DAO<T> {

    List<T> getAll() throws SQLException;
    void updateCount(long bookId, int bookCount) throws SQLException;
    List<BookDto> getAllDto() throws SQLException;
}
