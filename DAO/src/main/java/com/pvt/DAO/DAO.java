package com.pvt.DAO;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {

    T save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    EntityManager openEm();

    void closeEm();

    EntityManager openEmTransact();

    void closeEmTransact();

    EntityManager getEm();

}