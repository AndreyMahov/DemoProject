package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Role;
import com.prideTeam.AstonWebSchool.repositories.RoleCrudRepository;
import com.prideTeam.AstonWebSchool.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleCrudRepository repo;

    public RoleServiceImpl(RoleCrudRepository repo) {
        this.repo = repo;
    }


    @Override
    public Role save(Role role) {
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
        return repo.findByRole(roleName);
    }
}
