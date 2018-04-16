package com.pvt.services;

import com.pvt.entities.Item;

import java.io.Serializable;
import java.util.List;

public interface ItemService {

    Item save(Item item);

    Item get(Serializable id);

    void update(Item item);

    int delete(Serializable id);

    List<Item> getByFormularId(long formularId);
}
