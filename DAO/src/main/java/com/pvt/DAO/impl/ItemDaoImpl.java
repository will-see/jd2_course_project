package com.pvt.DAO.impl;

import com.pvt.DAO.ItemDao;
import com.pvt.entities.Item;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends AbstractDao implements ItemDao {
    private static volatile ItemDao INSTANCE = null;

    private static final String saveItemQuery = "INSERT INTO ITEM (formularId, bookId) VALUES (?, ?)";
    private static final String getItemQuery = "SELECT * FROM ITEM WHERE itemId=?";
    private static final String updateItemQuery = "UPDATE ITEM SET bookId=? WHERE itemId=?";
    private static final String deleteItemQuery = "DELETE FROM ITEM WHERE itemId=?";
    private static final String getItemsByUserIdQuery = "SELECT * FROM ITEM WHERE formularId = ?";

    private PreparedStatement psSave;
    private PreparedStatement psGet;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    private PreparedStatement psGetAll;

    private ItemDaoImpl() {
    }

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

    @Override
    public Item save(Item item) throws SQLException {
        psSave = prepareStatement(saveItemQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setLong(1, item.getFormularId());
        psSave.setLong(2, item.getBookId());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            item.setId(rs.getLong(1));
        }
        close(rs);
        return item;
    }

    @Override
    public Item get(Serializable id) throws SQLException {
        psGet = prepareStatement(getItemQuery);
        psGet.setLong(1, (long)id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateBook(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Item item) throws SQLException {
        psUpdate = prepareStatement(updateItemQuery);
        psUpdate.setLong(2, item.getId());
        psUpdate.setLong(1, item.getBookId());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete = prepareStatement(deleteItemQuery);
        psDelete.setLong(1, (long)id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Item> getByFormularId(long formularId) throws SQLException {
        psGetAll = prepareStatement(getItemsByUserIdQuery);
        psGetAll.setLong(1, formularId);
        psGetAll.execute();
        List<Item> list = new ArrayList<>();
        ResultSet rs = psGetAll.getResultSet();
        while (rs.next()) {
            list.add(populateBook(rs));
        }
        close(rs);
        return list;
    }

    private Item populateBook(ResultSet rs) throws SQLException {
        Item entity = new Item();
        entity.setId(rs.getLong(1));
        entity.setFormularId(rs.getLong(2));
        entity.setBookId(rs.getInt(3));
        return entity;
    }
}