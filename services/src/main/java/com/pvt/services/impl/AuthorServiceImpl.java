package com.pvt.services.impl;

import com.pvt.DAO.AuthorDao;
import com.pvt.DAO.impl.AuthorDaoImpl;
import com.pvt.entities.Author;
import com.pvt.services.AuthorService;
import com.pvt.services.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class AuthorServiceImpl extends AbstractService implements AuthorService {
    private static volatile AuthorService INSTANCE = null;
    private AuthorDao authorDao = AuthorDaoImpl.getInstance();

    @Override
    public Author getByName(String name) {
        try {
            return authorDao.getByName(name);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Author by login" + name);
        }
    }

    @Override
    public List<Author> getAll() {
        try {
            startTransaction();
            List<Author> list = authorDao.getAll();
            commit();
            return list;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Authors");
        }
    }

    public static AuthorService getInstance() {
        AuthorService authorService = INSTANCE;
        if (authorService == null) {
            synchronized (AuthorServiceImpl.class) {
                authorService = INSTANCE;
                if (authorService == null) {
                    INSTANCE = authorService = new AuthorServiceImpl();
                }
            }
        }

        return authorService;
    }
}
