package com.pvt.services.impl;

import com.pvt.DAO.RoleDao;
import com.pvt.DAO.impl.RoleDaoImpl;
import com.pvt.services.RoleService;

public class RoleServiceImpl extends AbstractService implements RoleService {
    private static volatile RoleService INSTANCE = null;
    private RoleDao authorDao = RoleDaoImpl.getInstance();



    public static RoleService getInstance() {
        RoleService RoleService = INSTANCE;
        if (RoleService == null) {
            synchronized (RoleServiceImpl.class) {
                RoleService = INSTANCE;
                if (RoleService == null) {
                    INSTANCE = RoleService = new RoleServiceImpl();
                }
            }
        }

        return RoleService;
    }
}
