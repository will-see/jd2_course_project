package com.pvt.DAO.impl;

import com.pvt.DAO.DAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@NoArgsConstructor
@Repository
public class BaseDao<T> implements DAO<T> {
    @Setter
    Class<T> clazz;
    @PersistenceContext
    @Getter
    private EntityManager em;

    @Override
    public T add(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T get(Serializable id) {
        return em.find(clazz, id);
    }


    @Override
    public T update(T t) {
        em.merge(t);
        return t;
    }

    @Override
    public void delete(Serializable id) {
        T t = em.find(clazz, id);
        em.remove(t);
    }
}