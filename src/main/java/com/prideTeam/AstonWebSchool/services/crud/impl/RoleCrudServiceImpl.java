package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Role;
import com.prideTeam.AstonWebSchool.repositories.RoleRepository;
import com.prideTeam.AstonWebSchool.services.crud.RoleCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleCrudServiceImpl implements RoleCrudService {
    private final RoleRepository roleRepository;

    public RoleCrudServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public Role getById(Integer roleId) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(Integer roleId) {

    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByRole(roleName);
    }
}
