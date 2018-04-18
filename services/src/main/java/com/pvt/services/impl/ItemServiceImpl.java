package com.pvt.services.impl;

import com.pvt.DAO.ItemDao;
import com.pvt.DAO.impl.ItemDaoImpl;
import com.pvt.entities.Item;
import com.pvt.services.ItemService;
import com.pvt.services.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class ItemServiceImpl extends AbstractService implements ItemService {
    private ItemDao itemDao = ItemDaoImpl.getInstance();

    @Override
    public Item save(Item item) {
        try {
            item = itemDao.save(item);
        } catch (SQLException e) {
            throw new ServiceException("Error creating Item" + item);
        }
        return item;
    }

    @Override
    public Item get(Serializable id) {
        try {
            return itemDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error geting Item by id " + id);
        }
    }

    @Override
    public void update(Item item) {
        try {
            itemDao.update(item);
        } catch (SQLException e) {
            throw new ServiceException("Error updating Item" + item);
        }
    }

    @Override
    public void delete(Item item) {
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
