package com.pvt.DAO;

import com.pvt.entities.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao<T> extends DAO<T>{
    List<T> getByFormularId(long formularId) throws SQLException;
}