package com.pvt.services;

import com.pvt.dto.FormularDto;

import java.util.List;


public interface FormularService<T>extends Service<T> {

    List<T> getByUserId(long userId);
    List<FormularDto> getUserBooksInFormular(long userId);
}
