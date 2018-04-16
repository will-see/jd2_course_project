package com.pvt.DAO.impl;

import com.pvt.DAO.BookDao;
import com.pvt.dto.BookDto;
import com.pvt.entities.Book;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends AbstractDao implements BookDao {
    private static volatile BookDao INSTANCE = null;

    private static final String saveBookQuery = "INSERT INTO books (name, ganr, pages, authorId,book_count ) VALUES (?, ?, ?, ?, ?)";
    private static final String updateBookQuery = "UPDATE books SET book_count=? WHERE bookId=?";
    private static final String getBookByIdQuery = "SELECT * FROM books WHERE bookId=?";
    private static final String getAllBookQuery = "SELECT bookId, name, ganr,pages, author_name, book_count FROM books JOIN authors a ON books.authorId = a.id_author order by bookId;";
    private static final String getByNameAndGanrQuery = "SELECT * FROM books WHERE name=? AND ganr=?";
    private static final String deleteBookQuery = "DELETE FROM books WHERE bookId=?";

    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetByNameAndGanr;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    private BookDaoImpl() {
    }

    @Override
    public Book save(Book book) throws SQLException {
        psSave = prepareStatement(saveBookQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setString(1, book.getName());
        psSave.setString(2, book.getGanr());
        psSave.setInt(3, book.getPages());
        psSave.setLong(4, book.getAuthorId());
        psSave.setInt(5, book.getBookCount());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            book.setBookId(rs.getLong(1));
        }
        close(rs);
        return book;
    }

    @Override
    public Book get(Serializable bookId) throws SQLException {
        psGet = prepareStatement(getBookByIdQuery);
        psGet.setLong(1, (long) bookId);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateBook(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Book book) throws SQLException {
        psUpdate = prepareStatement(updateBookQuery);
        psUpdate.setLong(1, book.getBookId());
//        psUpdate.setString(2, book.getName());
//        psUpdate.setString(3, book.getGanr());
//        psUpdate.setInt(4, book.getPages());
//        psUpdate.setLong(5, book.getAuthorId());
        psUpdate.setInt(2, book.getBookCount());
        psUpdate.executeUpdate();
    }
    @Override
    public void updateCount(long bookId, int bookCount) throws SQLException {
        psUpdate = prepareStatement(updateBookQuery);
        psUpdate.setLong(2, bookId);
//        psUpdate.setString(2, book.getName());
//        psUpdate.setString(3, book.getGanr());
//        psUpdate.setInt(4, book.getPages());
//        psUpdate.setLong(5, book.getAuthorId());
        psUpdate.setInt(1, bookCount);
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable bookId) throws SQLException {
        psDelete = prepareStatement(deleteBookQuery);
        psDelete.setLong(1, (long) bookId);
        return psDelete.executeUpdate();
    }

    @Override
    public Book getByNameAndGanr(String name, String ganr) throws SQLException {
        psGetByNameAndGanr = prepareStatement(getByNameAndGanrQuery);
        psGetByNameAndGanr.setString(1, name);
        psGetByNameAndGanr.setString(2, ganr);
        psGetByNameAndGanr.execute();
        ResultSet rs = psGetByNameAndGanr.getResultSet();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getLong(1));
            book.setName(rs.getString(2));
            book.setGanr(rs.getString(3));
            book.setPages(rs.getInt(4));
            book.setAuthorId(rs.getLong(5));
            book.setBookCount(rs.getInt(6));
        }
        close(rs);

        return null;
    }

    @Override
    public List<BookDto> getAll() throws SQLException {
        psGetAll = prepareStatement(getAllBookQuery);
        psGetAll.execute();
        ResultSet rs = psGetAll.getResultSet();
        List<BookDto> list = new ArrayList<>();
        while (rs.next()) {
            list.add(populateBookDto(rs));
        }
        close(rs);
        return list;
    }

    private Book populateBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getLong(1));
        book.setName(rs.getString(2));
        book.setGanr(rs.getString(3));
        book.setPages(rs.getInt(4));
        book.setAuthorId(rs.getLong(5));
        book.setBookCount(rs.getInt(6));
        return book;
    }
    private BookDto populateBookDto(ResultSet rs) throws SQLException {
        BookDto bookDto = new BookDto();
        bookDto.setBookId(rs.getInt(1));
        bookDto.setName(rs.getString(2));
        bookDto.setGanr(rs.getString(3));
        bookDto.setPages(rs.getInt(4));
        bookDto.setAuthor(rs.getString(5));
        bookDto.setBookCount(rs.getInt(6));
        return bookDto;
    }

    public static BookDao getInstance() {
        BookDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (BookDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new BookDaoImpl();
                }
            }
        }
        return productDao;
    }
}
