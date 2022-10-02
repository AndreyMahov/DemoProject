package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.repositories.LogCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.LogCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LogCrudServiceImpl implements LogCrudService {

    private final LogCrudRepository logCrudRepository;

    @Autowired
    public LogCrudServiceImpl(LogCrudRepository logCrudRepository) {
        this.logCrudRepository = logCrudRepository;
    }

    @Override
    @Transactional
    public Log create(Log log, Integer studentId) {
        //TODO
        return null;
    }

    @Override
    public Log getById(Integer logId, Integer studentId) {
        //TODO
        return null;
    }

    @Override
    public List<Log> getAll(Integer studentId) {
        //TODO
        return null;
    }

    @Override
    @Transactional
    public void update(Log log, Integer logId, Integer studentId) {
        //TODO
    }

    @Override
    @Transactional
    public void delete(Integer logId, Integer studentId) {
        //TODO
    }
}
