package com.pvt.services.impl;

import com.pvt.DAO.AuthorDao;
import com.pvt.DAO.impl.AuthorDaoImpl;
import com.pvt.entities.Author;
import com.pvt.services.AuthorService;
import com.pvt.services.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService<Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author getByName(String name) {
        try {
            return (Author)authorDao.getByName(name);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Author by login" + name);
        }
    }

    @Override
    public List<Author> getAll() {
        try {
            List<Author> list = authorDao.getAll();
            return list;
        } catch (SQLException e) {
            throw new ServiceException("Error getting Authors");
        }
    }

    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Override
    public Author get(Serializable id) {
        return (Author) authorDao.get(id);
    }

    @Override
    public void deleteId(Serializable id) {
        authorDao.delete(id);
    }
}
