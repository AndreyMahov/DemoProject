package com.prideTeam.AstonWebSchool.repositories;

import com.prideTeam.AstonWebSchool.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogCrudRepository extends JpaRepository<Log,Integer> {
    List<Log> findAllByStudentId(Integer student_id);
}
