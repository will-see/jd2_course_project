package com.pvt.services.impl;

import com.pvt.DAO.RoleDao;
import com.pvt.DAO.impl.RoleDaoImpl;
import com.pvt.entities.Role;
import com.pvt.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional
public class RoleServiceImpl implements RoleService<Role> {

    @Autowired
    RoleDao roleDao;

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public Role get(Serializable id) {
        return (Role) roleDao.get(id);
    }

    @Override
    public void deleteId(Serializable id) {
        roleDao.delete(id);
    }
}
