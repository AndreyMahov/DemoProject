package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Admin;

import java.util.List;

public interface AdminCrudService {
    Admin create(Admin admin);

    Admin getById(Integer adminId);

    List<Admin> getAll();

    void update(Admin admin, Integer id);

    void delete(Integer adminId);

}
