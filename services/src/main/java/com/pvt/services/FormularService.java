package com.pvt.services;

import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;

import java.io.Serializable;
import java.util.List;


public interface FormularService {

    Formular createFormular(long userId, long bookId);
    Formular get(Serializable id);
    void update(Formular formular);
    void delete(Formular formular);

    List<Formular> getByUserId(long userId);
    List<FormularDto> getUserFormular(long userId);
}
