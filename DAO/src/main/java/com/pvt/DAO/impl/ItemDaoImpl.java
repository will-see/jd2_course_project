package com.pvt.DAO.impl;

import com.pvt.DAO.ItemDao;
import com.pvt.entities.Formular;
import com.pvt.entities.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemDaoImpl extends BaseDao<Item> implements ItemDao<Item> {

    public ItemDaoImpl(){
        super();
        clazz = Item.class;
    }

//    private static final String saveItemQuery = "INSERT INTO ITEM (formularId, bookId) VALUES (?, ?)";
//    private static final String getItemQuery = "SELECT * FROM ITEM WHERE itemId=?";
//    private static final String updateItemQuery = "UPDATE ITEM SET bookId=? WHERE itemId=?";
//    private static final String deleteItemQuery = "DELETE FROM ITEM WHERE itemId=?";
//    private static final String getItemsByUserIdQuery = "SELECT * FROM ITEM WHERE formularId = ?";

    @Override
    public List<Item> getByFormularId(long formularId) throws SQLException {
            Query query = getEm().createQuery("from Item where formularId= :formularId");
//            Query query = getEm().createNativeQuery("SELECT * FROM ITEM WHERE formularId = ?");
            return query.getResultList();
    }
}