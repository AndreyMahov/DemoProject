package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Role;

import java.util.List;

public interface RoleCrudService {
    Role create(Role role);

    Role getById(Integer roleId);

    List<Role> getAll();

    void update(Role role, Integer roleId);

    void delete(Integer roleId);

    Role findByName(String roleName);

}
