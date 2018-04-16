package com.pvt.DAO;

import com.pvt.entities.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends DAO<Item>{
    List<Item> getByFormularId(long formularId) throws SQLException;
}