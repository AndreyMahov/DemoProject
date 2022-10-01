package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Role;
import com.prideTeam.AstonWebSchool.entity.Student;

import java.util.List;

public interface RoleService {
    Role save(Role role);

    Role getById(Integer roleId);

    List<Role> getAll();

    void update(Role role);

    void delete(Integer roleId);

}
