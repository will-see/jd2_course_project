package com.pvt.DAO.impl;

import com.pvt.DAO.RoleDao;
import com.pvt.entities.Role;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class RoleDaoImpl extends BaseDao<Role> implements RoleDao<Role> {

    public RoleDaoImpl(){
        super();
        clazz = Role.class;
    }
}
