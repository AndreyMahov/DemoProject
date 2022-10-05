package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Role;
import com.prideTeam.AstonWebSchool.repositories.RoleCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.RoleCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class RoleCrudServiceImpl implements RoleCrudService {
    private final RoleCrudRepository roleCrudRepository;

    public RoleCrudServiceImpl(RoleCrudRepository roleCrudRepository) {
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    @Transactional
    public Role create(Role role) {
        return roleCrudRepository.save(role);
    }

    @Override
    public Role getById(Integer roleId) {
        return roleCrudRepository.findById(roleId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Role> getAll() {
        return roleCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Role role, Integer roleId) {
        if (!Objects.equals(role.getId(), roleId)) {
            throw new EntityNotFoundException();
        }
        roleCrudRepository.save(role);
    }

    @Override
    @Transactional
    public void delete(Integer roleId) {
        roleCrudRepository.deleteById(roleId);
    }

    @Override
    public Role findByName(String roleName) {
        return roleCrudRepository.findByRole(roleName);
    }
}
