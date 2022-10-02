package com.prideTeam.AstonWebSchool.services.impl;


import com.prideTeam.AstonWebSchool.entity.Admin;
import com.prideTeam.AstonWebSchool.repositories.AdminCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.RoleRepository;
import com.prideTeam.AstonWebSchool.services.AdminCrudService;
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
    private final AdminCrudRepository repo;
    private final RoleRepository roleRepo;

    public AdminCrudServiceImpl(AdminCrudRepository repo, RoleRepository roleRepo) {
        this.repo = repo;
        this.roleRepo = roleRepo;
    }

    @Override
    @Transactional
    public Admin save(Admin admin) {
        admin.setRole(roleRepo.findByRole(ADMIN_ROLE));
        admin.setRegistered(LocalDate.now());
        return repo.save(admin);
    }

    @Override
    public Admin getById(Integer adminId) {
        return repo.findById(adminId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Admin> getAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void update(Admin admin, Integer id) {
        if (!Objects.equals(admin.getId(), id))
            throw new EntityNotFoundException();
        repo.save(admin);
    }

    @Override
    @Transactional
    public void delete(Integer adminId) {
        repo.delete(repo.getReferenceById(adminId));
    }
}
