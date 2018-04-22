package com.pvt.services;

import java.util.List;

public interface AuthorService<T> extends Service<T> {
    T getByName(String name);
    List<T> getAll();
}
