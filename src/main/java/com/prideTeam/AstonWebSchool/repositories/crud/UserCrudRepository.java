package com.prideTeam.AstonWebSchool.repositories.crud;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends JpaRepository<AbstractBaseUser, Integer> {
}
