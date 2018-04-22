package com.pvt.DAO;

import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;

import java.sql.SQLException;
import java.util.List;

public interface FormularDao<T> extends DAO <T> {
        List<T> getByUserId(long userId) throws SQLException;
        List<FormularDto> getUserFormular(long userId) throws SQLException;
}
