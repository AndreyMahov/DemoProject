package com.prideTeam.AstonWebSchool.repositories.crud;

import com.prideTeam.AstonWebSchool.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCrudRepository extends JpaRepository<Group, Integer> {
}
