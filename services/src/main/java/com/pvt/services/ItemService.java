package com.pvt.services;

import java.util.List;

public interface ItemService<T> extends Service<T> {

    List<T> getByFormularId(long formularId);
}
