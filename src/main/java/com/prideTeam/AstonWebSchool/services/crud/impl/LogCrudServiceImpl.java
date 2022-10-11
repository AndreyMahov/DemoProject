package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.crud.LogCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.crud.UserCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.LogCrudService;
import com.prideTeam.AstonWebSchool.util.HibernateUtil;
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
    private final UserCrudRepository userCrudRepository;

    @Autowired
    public LogCrudServiceImpl(LogCrudRepository logCrudRepository, UserCrudRepository userCrudRepository) {
        this.logCrudRepository = logCrudRepository;
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    @Transactional
    public Log create(Log log, Integer studentId) {
        log.setRegistered(LocalDate.now());
        log.setStudent(
                (Student) HibernateUtil.initializeAndUnproxy(userCrudRepository.getReferenceById(studentId))
        );
        return logCrudRepository.save(log);
    }

    @Override
    public Log getByLogIdAndStudentId(Integer logId, Integer studentId) {
        return logCrudRepository.getByIdAndStudentId(logId, studentId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Log> getAll(Integer studentId) {
        return logCrudRepository.getAllByStudentId(studentId);
    }

    @Override
    @Transactional
    public void update(Log log, Integer logId, Integer studentId) {
        if (!Objects.equals(log.getId(), logId)) {
            throw new EntityNotFoundException();
        }
        Log updated = logCrudRepository.getByIdAndStudentId(logId, studentId).orElseThrow(EntityNotFoundException::new);
        //TODO: РЕАЛИЗОВАТЬ update. На данный момент при обновлениии части полей, перезаписываются все данные
        //TODO: Это плохо, надо менять. Учесть, что обновлять лог можно, если approved = false
    }

    @Override
    @Transactional
    public void delete(Integer logId, Integer studentId) {
        if (logCrudRepository.deleteByIdAndStudentIdAndApprovedFalse(logId, studentId) == 0)
            throw new IllegalArgumentException("log not found or log is already approved");
    }

    @Override
    @Transactional
    public void setApprove(Integer logId, Integer studentId, Boolean approved) {
        if (logCrudRepository.setApprove(logId, studentId, approved) == 0)
            throw new EntityNotFoundException();
    }
}
