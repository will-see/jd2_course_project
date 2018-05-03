package com.pvt.services.impl;

import com.pvt.DAO.FormularDao;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;
import com.pvt.services.FormularService;
import com.pvt.services.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class FormularServiceImpl implements FormularService<Formular> {

    @Autowired
    FormularDao formularDao;

//    @Override
//    public Formular createFormular(long userId, long bookId) {
//        Formular formular = new Formular();
//        try {
////            formular.setUserId(userId);
//            formular.setBookId(bookId);
//            formularDao.save(formular);
//            return formular;
//        } catch (SQLException e) {
//            throw new ServiceException("Error creating Formular" + formular, e);
//        }
//    }


    @Override
    public void add(Formular formular) {
        formularDao.add(formular);
    }


    @Override
    public Formular get(Serializable id) {
            return (Formular)formularDao.get(id);
    }

    @Override
    public void update(Formular formular) {
            formularDao.update(formular);
    }

    @Override
    public void deleteId(Serializable id) {
        formularDao.delete(id);
    }

    @Override
    public List<Formular> getByUserId(long userId) {
        try {
            return formularDao.getByUserId(userId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Formularss by userId" + userId);
        }
    }

    @Override
    public List<FormularDto> getUserBooksInFormular(long userId) {
        try {
            return formularDao.getUserBooksInFormular(userId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User Formular by userId" + userId);
        }
    }

}
