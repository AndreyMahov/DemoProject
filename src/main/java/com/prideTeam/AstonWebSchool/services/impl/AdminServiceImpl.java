package com.prideTeam.AstonWebSchool.services.impl;


import com.prideTeam.AstonWebSchool.entity.Admin;
import com.prideTeam.AstonWebSchool.repositories.AdminRepository;
import com.prideTeam.AstonWebSchool.services.AdminService;
import com.prideTeam.AstonWebSchool.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    @Transactional(readOnly = true)
    public Admin getById(Integer adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new ExpressionException("админа с таким id нет"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public void update(int id, Admin admin) {
        admin.setId(id);
        adminRepository.save(admin);
    }

    @Override
    public void delete(Integer adminId) {
        adminRepository.deleteById(adminId);
    }
}
