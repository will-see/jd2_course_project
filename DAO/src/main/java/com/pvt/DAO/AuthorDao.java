package com.pvt.DAO;

import com.pvt.entities.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao<T> extends DAO<T> {
    T getByName(String name) throws SQLException;
    List<T> getAll() throws SQLException;
}
