package com.prideTeam.AstonWebSchool.repositories.crud;

import com.prideTeam.AstonWebSchool.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogCrudRepository extends JpaRepository<Log,Integer> {
    Optional<Log> getByIdAndStudentId(Integer id, Integer studentId);

    List<Log> getAllByStudentId(Integer studentId);

    int deleteByIdAndStudentIdAndApprovedFalse(Integer id, Integer studentId);

    @Modifying
    @Query(name = Log.SET_APPROVE_QUERY)
    int setApprove(@Param("logId") Integer logId, @Param("studentId") Integer studentId, @Param("approved") Boolean approved);
}
