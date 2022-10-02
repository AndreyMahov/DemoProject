package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.repositories.LogRepository;
import com.prideTeam.AstonWebSchool.services.CrudService;
import com.prideTeam.AstonWebSchool.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    @Override
    public Log save(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log getById(Integer logId) {
        return logRepository.findById(logId).orElseThrow(() -> new ExpressionException("лога с таким id нет"));
    }

    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }

    @Override
    public void update(int id, Log log) {
        log.setId(id);
        logRepository.save(log);
    }

    @Override
    public void delete(Integer logId) {
        logRepository.deleteById(logId);
    }
}
