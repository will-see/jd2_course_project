package com.pvt.DAO.impl;

import com.pvt.DAO.RoleDao;
import com.pvt.entities.Role;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDaoImpl extends AbstractDao implements RoleDao {
    private static volatile RoleDao INSTANCE = null;


    public static RoleDao getInstance() {
        RoleDao roleDao = INSTANCE;
        if (roleDao == null) {
            synchronized (RoleDaoImpl.class) {
                roleDao = INSTANCE;
                if (roleDao == null) {
                    INSTANCE = roleDao = new RoleDaoImpl();
                }
            }
        }
        return roleDao;
    }

    @Override
    public Role save(Role role) throws SQLException {
        getEm().persist(role);
        return role;
    }

    @Override
    public Role get(Serializable id) throws SQLException {
        return getEm().find(Role.class, id);
    }

    @Override
    public void update(Role role) throws SQLException {
        getEm().merge(role);
    }

    @Override
    public void delete(Role role) throws SQLException {
        getEm().remove(role);
    }

}
