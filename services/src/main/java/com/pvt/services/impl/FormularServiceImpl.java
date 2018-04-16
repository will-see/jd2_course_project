package com.pvt.services.impl;

import com.pvt.DAO.BookDao;
import com.pvt.DAO.FormularDao;
import com.pvt.DAO.ItemDao;
import com.pvt.DAO.impl.BookDaoImpl;
import com.pvt.DAO.impl.FormularDaoImpl;
import com.pvt.DAO.impl.ItemDaoImpl;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;
import com.pvt.services.FormularService;
import com.pvt.services.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


public class FormularServiceImpl extends AbstractService implements FormularService {
    private static volatile FormularService INSTANCE = null;

    private FormularDao formularDao = FormularDaoImpl.getInstance();
    private BookDao bookDao = BookDaoImpl.getInstance();
    private ItemDao itemDao = ItemDaoImpl.getInstance();

//    @Override
//    public Formular createFormular(long userId, long bookId) {
//        Formular formular = new Formular();
//        try {
//            startTransaction();
//            formular.setUserId(userId);
//            formular.setBookId(bookId);
//
//            formular = formularDao.save(formular);
//
//            Item item = new Item(formular.getFormularId(), bookId);
//            itemDao.save(item);
//            commit();
//            return formular;
//        } catch (SQLException e) {
//            rollback();
//            throw new ServiceException("Error creating Formular " + formular, e);
//        }
//    }


    @Override
    public Formular createFormular(long userId, long bookId) {
        Formular formular = new Formular();
        try {
            formular.setUserId(userId);
            formular.setBookId(bookId);
            formularDao.save(formular);
            return formular;
        } catch (SQLException e) {
            throw new ServiceException("Error creating Formular" + formular, e);
        }
    }

    @Override
    public Formular get(Serializable id) {
        try {
            return formularDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Formular by id" + id);
        }
    }

    @Override
    public void update(Formular formular) {
        try {
            formularDao.update(formular);
        } catch (SQLException e) {
            throw new ServiceException("Error updating Formular by id" + formular);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            return formularDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting Formular by id" + id);
        }
    }

    @Override
    public List<Formular> getByUserId(long userId) {
        try {
//            startTransaction();
//            List<Formular> formulars = formularDao.getByUserId(userId);
//            for (Formular formular : formulars) {
//                List<Item> items = itemDao.getByFormularId(formular.getFormularId());
//                formular.setItems(items);
//                double sum = 0;
//                for (Item item : items) {
//                    Book book = bookDao.get(item.getBookId());
//                    sum += product.getPrice() * item.getQuantity();
//                }
//                commit();
//                formular.setTotal(sum);
//            }
            return formularDao.getByUserId(userId);
        } catch (SQLException e) {
//            rollback();
            throw new ServiceException("Error getting Formularss by userId" + userId);
        }
    }

    @Override
    public List<FormularDto> getUserFormular(long userId) {
        try {
        return formularDao.getUserFormular(userId);
    } catch (SQLException e) {
//            rollback();
        throw new ServiceException("Error getting User Formular by userId" + userId);
    }
    }

    public static FormularService getInstance() {
        FormularService formularService = INSTANCE;
        if (formularService == null) {
            synchronized (FormularServiceImpl.class) {
                formularService = INSTANCE;
                if (formularService == null) {
                    INSTANCE = formularService = new FormularServiceImpl();
                }
            }
        }

        return formularService;
    }
}
