package com.prideTeam.AstonWebSchool.repositories;

import com.prideTeam.AstonWebSchool.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherGroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findGroupsByTeachersId(Integer teacherId);
}
