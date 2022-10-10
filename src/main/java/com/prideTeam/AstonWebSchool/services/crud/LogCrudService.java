package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Log;

import java.util.List;

public interface LogCrudService {
    Log create(Log log, Integer studentId);

    Log getByLogIdAndStudentId(Integer logId, Integer studentId);

    List<Log> getAll(Integer studentId);

    void update(Log log, Integer logId, Integer studentId);

    void delete(Integer logId, Integer studentId);

    void setApprove(Integer logId, Integer studentId, Boolean approved);
}
