package com.pvt.services;

import java.io.Serializable;

public interface Service<T> {
    void add(T t);
    void update(T t);
    T get(Serializable id);
    void deleteId(Serializable id);
}
