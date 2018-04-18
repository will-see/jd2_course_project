package com.pvt.DAO.impl;

import com.pvt.DAO.ItemDao;
import com.pvt.entities.Formular;
import com.pvt.entities.Item;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends AbstractDao implements ItemDao {
    private static volatile ItemDao INSTANCE = null;

    public static ItemDao getInstance() {
        ItemDao itemDao = INSTANCE;
        if (itemDao == null) {
            synchronized (ItemDaoImpl.class) {
                itemDao = INSTANCE;
                if (itemDao == null) {
                    INSTANCE = itemDao = new ItemDaoImpl();
                }
            }
        }
        return itemDao;
    }

    private static final String saveItemQuery = "INSERT INTO ITEM (formularId, bookId) VALUES (?, ?)";
    private static final String getItemQuery = "SELECT * FROM ITEM WHERE itemId=?";
    private static final String updateItemQuery = "UPDATE ITEM SET bookId=? WHERE itemId=?";
    private static final String deleteItemQuery = "DELETE FROM ITEM WHERE itemId=?";
    private static final String getItemsByUserIdQuery = "SELECT * FROM ITEM WHERE formularId = ?";

    @Override
    public Item save(Item item) throws SQLException {
        getEm().persist(item);
        return item;
    }

    @Override
    public Item get(Serializable id) throws SQLException {
        return getEm().find(Item.class, id);
    }

    @Override
    public void update(Item item) throws SQLException {
        getEm().merge(item);
    }

    @Override
    public void delete(Item item) throws SQLException {
        getEm().remove(item);
    }

    @Override
    public List<Item> getByFormularId(long formularId) throws SQLException {
            Query query = getEm().createQuery("from Item where formularId= :formularId");
//            Query query = getEm().createNativeQuery("SELECT * FROM ITEM WHERE formularId = ?");
            return query.getResultList();
    }
}