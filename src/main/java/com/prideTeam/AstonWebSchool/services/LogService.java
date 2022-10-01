package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Log;

import java.util.List;

public interface LogService {
    Log save(Log log);

    Log getById(Integer logId);

    List<Log> getAll();

    void update(Log role);

    void delete(Integer roleId);
}
