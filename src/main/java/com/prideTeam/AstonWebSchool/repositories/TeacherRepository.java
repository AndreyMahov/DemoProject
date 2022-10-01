package com.prideTeam.AstonWebSchool.repositories;

import com.prideTeam.AstonWebSchool.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
