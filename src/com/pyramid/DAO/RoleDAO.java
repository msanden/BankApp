package com.pyramid.DAO;

import com.pyramid.Storage;
import com.pyramid.entities.Role;
import com.pyramid.entities.User;

public class RoleDAO {

    public Role getRoleByUserId(long id) {
        for (User user : Storage.getUsers()) {
            if (user.getId() == id) {
                return user.getRole();
            }
        }

        return null;
    }
}