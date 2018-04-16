package com.pvt.services;

import com.pvt.entities.Author;

import java.util.List;

public interface AuthorService {
    Author getByName(String name);
    List<Author> getAll();
}
