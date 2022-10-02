package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Admin;

import java.util.List;

public interface AdminCrudService {
    Admin save(Admin admin);

    Admin getById(Integer adminId);

    List<Admin> getAll();

    void update(Admin admin, Integer id);

    void delete(Integer adminId);

}
