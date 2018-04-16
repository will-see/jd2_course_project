package com.pvt.DAO.impl;

import com.pvt.DAO.RoleDao;
import com.pvt.entities.Role;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDaoImpl extends AbstractDao implements RoleDao {
    private static volatile RoleDao INSTANCE = null;

//    private static final String saveRoleQuery = "INSERT INTO roles (id_role, role) VALUES (?, ?)";
//    private static final String getRoleQuery = "SELECT * FROM roles WHERE id_role=?";
//    private static final String updateRoleQuery = "UPDATE roles SET id_role=? WHERE role=?";
//    private static final String deleteRoleQuery = "DELETE FROM roles WHERE itemId=?";
//    private static final String getRoleByUserIdQuery = "SELECT * FROM roles WHERE id_role = ?";

//    private PreparedStatement psSave;
//    private PreparedStatement psGet;
//    private PreparedStatement psUpdate;
//    private PreparedStatement psDelete;
//    private PreparedStatement psGetAll;

//    private RoleDaoImpl() {
//    }

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
        return null;
    }

    @Override
    public Role get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Role role) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }

    private Role populateEntity(ResultSet rs) throws SQLException {
        Role entity = new Role();
        entity.setRoleId(rs.getLong(1));
        entity.setRole(rs.getString(2));
        return entity;
    }


}
