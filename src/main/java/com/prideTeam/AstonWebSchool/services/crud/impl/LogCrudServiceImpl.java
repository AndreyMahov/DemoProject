package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.LogCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.StudentCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.LogCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class LogCrudServiceImpl implements LogCrudService {

    private final LogCrudRepository logCrudRepository;
    private final StudentCrudRepository studentCrudRepository;

    @Autowired
    public LogCrudServiceImpl(LogCrudRepository logCrudRepository, StudentCrudRepository studentCrudRepository) {
        this.logCrudRepository = logCrudRepository;
        this.studentCrudRepository = studentCrudRepository;
    }

    @Override
    @Transactional
    public Log create(Log log) {
        return logCrudRepository.save(log);
    }

    @Override
    public Log getById(Integer logId, Integer studentId) {
        Log currentLog = logCrudRepository.findById(logId).orElseThrow(EntityNotFoundException::new);
        if (! currentLog.getStudent().getId().equals(studentId))
            throw new EntityNotFoundException(); //вот тут должна быть ошибка доступа
        return null;
    }

    @Override
    public List<Log> getAll(Integer studentId) {
        Student currentStudent = studentCrudRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
        return currentStudent.getLogs();
    }

    @Override
    @Transactional
    public void update(Log log, Integer studentId) {
        if (!log.getStudent().getId().equals(studentId))
            throw new EntityNotFoundException(); //вот тут должна быть ошибка доступа
        logCrudRepository.save(log);
    }

    @Override
    @Transactional
    public void delete(Integer logId, Integer studentId) {
        Log currentLog = logCrudRepository.findById(logId).orElseThrow(EntityNotFoundException::new);
        if (! currentLog.getStudent().getId().equals(studentId))
            throw new EntityNotFoundException(); //вот тут должна быть ошибка доступа
        logCrudRepository.delete(currentLog);
    }
}
