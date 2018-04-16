package com.pvt.DAO;

import com.pvt.entities.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao extends DAO<Author> {
    Author getByName(String name) throws SQLException;
    List<Author> getAll() throws SQLException;
}
