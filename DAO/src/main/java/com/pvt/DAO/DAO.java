package com.pvt.DAO;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {

    T add(T t);

    T get(Serializable id);

    T update(T t);

    void delete(Serializable id);

}