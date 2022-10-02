package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin save(Admin admin);

    Admin getById(Integer adminId);

    List<Admin> getAll();

    void update(int id, Admin admin);

    void delete(Integer adminId);

}
