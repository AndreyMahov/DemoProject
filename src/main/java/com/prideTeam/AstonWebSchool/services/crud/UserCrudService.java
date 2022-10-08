package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;

import java.util.List;

public interface UserCrudService {
    AbstractBaseUser create(AbstractBaseUser baseUser, String role);

    AbstractBaseUser getById(Integer baseUserId);

    List<AbstractBaseUser> getAll();

    void update(AbstractBaseUser baseUser, Integer baseUserId);

    void delete(Integer baseUserId);
}
