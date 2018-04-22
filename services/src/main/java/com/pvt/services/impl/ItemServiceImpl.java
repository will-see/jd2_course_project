package com.pvt.services.impl;

import com.pvt.DAO.ItemDao;
import com.pvt.DAO.impl.BaseDao;
import com.pvt.DAO.impl.ItemDaoImpl;
import com.pvt.entities.Item;
import com.pvt.services.ItemService;
import com.pvt.services.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService<Item> {

    @Autowired
    ItemDao itemDao;

    @Override
    public void add(Item item) {
            itemDao.add(item);
    }

    @Override
    public Item get(Serializable id) {
            return (Item) itemDao.get(id);
    }

    @Override
    public void update(Item item) {
            itemDao.update(item);
    }

    @Override
    public void deleteId(Serializable id) {
        itemDao.delete(id);
    }

    @Override
    public List<Item> getByFormularId(long formularId) {
        try {
            return itemDao.getByFormularId(formularId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting all items");
        }
    }
}
