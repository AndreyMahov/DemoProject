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
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    public Log create(Log log, Integer studentId) {
        log.setDate(LocalDate.now());
        if (!Objects.equals(log.getStudent().getId(), studentId))
            throw new EntityNotFoundException();
        return logCrudRepository.save(log);
    }

    @Override
    public Log getById(Integer logId, Integer studentId) {
        //TODO
        Log currentLog = logCrudRepository.findById(logId).orElseThrow(EntityNotFoundException::new);
        Student currentStudent = studentCrudRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        if (currentLog.getStudent().equals(currentStudent))
            return currentLog;
        else throw new EntityNotFoundException();
    }

    @Override
    public List<Log> getAll(Integer studentId) {
        if (studentCrudRepository.existsById(studentId))
            return logCrudRepository.findAll();
        else throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void update(Log log, Integer studentId) {
        if (!Objects.equals(log.getStudent().getId(), studentId))
            throw new EntityNotFoundException();
        logCrudRepository.save(log);
    }

    @Override
    @Transactional
    public void delete(Integer logId, Integer studentId) {
        //TODO
        Log currentLog = logCrudRepository.findById(logId).orElseThrow(EntityNotFoundException::new);
        Student currentStudent = studentCrudRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        if (currentLog.getStudent().equals(currentStudent))
            logCrudRepository.delete(currentLog);
        else throw new EntityNotFoundException();
    }
}
