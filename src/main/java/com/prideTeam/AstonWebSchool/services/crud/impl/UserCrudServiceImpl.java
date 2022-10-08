package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;
import com.prideTeam.AstonWebSchool.repositories.RoleCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.UserCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.UserCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class UserCrudServiceImpl implements UserCrudService {
    private final UserCrudRepository userCrudRepository;
    private final RoleCrudRepository roleCrudRepository;

    public UserCrudServiceImpl(UserCrudRepository userCrudRepository, RoleCrudRepository roleCrudRepository) {
        this.userCrudRepository = userCrudRepository;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    @Transactional
    public AbstractBaseUser create(AbstractBaseUser baseUser, String role) {
        baseUser.setRole(roleCrudRepository.findByRole(role));
        return userCrudRepository.save(baseUser);
    }

    @Override
    public AbstractBaseUser getById(Integer id) {
        return userCrudRepository.findById(id).orElseThrow();
    }

    @Override
    public List<AbstractBaseUser> getAll() {
        return userCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(AbstractBaseUser baseUser, Integer baseUserId) {
        if (!Objects.equals(baseUser.getId(), baseUserId))
            throw new EntityNotFoundException();
        userCrudRepository.save(baseUser);
    }

    @Override
    @Transactional
    public void delete(Integer baseUserId) {
        userCrudRepository.deleteById(baseUserId);
    }
}
