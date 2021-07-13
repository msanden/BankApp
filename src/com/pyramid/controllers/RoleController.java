package com.pyramid.controllers;

import com.pyramid.DAO.RoleDAO;
import com.pyramid.entities.Role;

public class RoleController {
    private final RoleDAO roleDAO = new RoleDAO();

    public Role getRoleById(long id) {
        return roleDAO.getRoleByUserId(id);
    }

}
