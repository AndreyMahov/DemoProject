package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.LogRepository;
import com.prideTeam.AstonWebSchool.repositories.StudentRepository;
import com.prideTeam.AstonWebSchool.services.crud.LogCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LogCrudServiceImpl implements LogCrudService {

    private final LogRepository logRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public LogCrudServiceImpl(LogRepository logRepository, StudentRepository studentRepository) {
        this.logRepository = logRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Log create(Log log, Integer studentId) {
        Student currentStudent = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        if (log.getStudent().equals(currentStudent)) {
            logRepository.save(log);
            return log;
        } else throw new EntityNotFoundException();
    }

    @Override
    public Log getById(Integer logId, Integer studentId) {
        Log currentLog = logRepository.findById(logId).orElseThrow(EntityNotFoundException::new);
        Student currentStudent = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        if (currentLog.getStudent().equals(currentStudent))
            return currentLog;
        else throw new EntityNotFoundException();
    }

    @Override
    public List<Log> getAll(Integer studentId) {
        if (studentRepository.existsById(studentId))
            return logRepository.findAll();
        else throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void update(Log log, Integer studentId) {
        Student currentStudent = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
        if (log.getStudent().equals(currentStudent))
            logRepository.save(log);
        else throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void delete(Integer logId, Integer studentId) {
        Log currentLog = logRepository.findById(logId).orElseThrow(EntityNotFoundException::new);
        Student currentStudent = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        if (currentLog.getStudent().equals(currentStudent))
            logRepository.delete(currentLog);
        else throw new EntityNotFoundException();
    }
}
