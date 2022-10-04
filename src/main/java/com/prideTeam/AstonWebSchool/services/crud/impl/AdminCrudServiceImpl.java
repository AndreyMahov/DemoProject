package com.prideTeam.AstonWebSchool.services.crud.impl;


import com.prideTeam.AstonWebSchool.entity.Admin;
import com.prideTeam.AstonWebSchool.repositories.AdminCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.RoleCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.AdminCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class AdminCrudServiceImpl implements AdminCrudService {
    private static final String ADMIN_ROLE = "admin";
    private final AdminCrudRepository adminCrudRepository;
    private final RoleCrudRepository roleCrudRepository;

    public AdminCrudServiceImpl(AdminCrudRepository adminCrudRepository, RoleCrudRepository roleCrudRepository) {
        this.adminCrudRepository = adminCrudRepository;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    @Transactional
    public Admin create(Admin admin) {
        admin.setRole(roleCrudRepository.findByRole(ADMIN_ROLE));
        admin.setRegistered(LocalDate.now());
        return adminCrudRepository.save(admin);
    }

    @Override
    public Admin getById(Integer adminId) {
        return adminCrudRepository.findById(adminId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Admin> getAll() {
        return adminCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Admin admin, Integer id) {
        if (!Objects.equals(admin.getId(), id))
            throw new EntityNotFoundException();
        adminCrudRepository.save(admin);
    }

    @Override
    @Transactional
    public void delete(Integer adminId) {
        adminCrudRepository.delete(adminCrudRepository.getReferenceById(adminId));
    }
}
