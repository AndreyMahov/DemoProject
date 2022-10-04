package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Teacher;
import com.prideTeam.AstonWebSchool.repositories.RoleCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.TeacherCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.TeacherCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class TeacherCrudServiceImpl implements TeacherCrudService {
    private static final String TEACHER_ROLE = "teacher";

    private final TeacherCrudRepository teacherCrudRepository;
    private final RoleCrudRepository roleCrudRepository;

    @Autowired
    public TeacherCrudServiceImpl(TeacherCrudRepository teacherCrudRepository, RoleCrudRepository roleCrudRepository) {
        this.teacherCrudRepository = teacherCrudRepository;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    @Transactional
    public Teacher create(Teacher teacher) {
        teacher.setRole(roleCrudRepository.findByRole(TEACHER_ROLE));
        teacher.setRegistered(LocalDate.now());
        return teacherCrudRepository.save(teacher);
    }

    @Override
    public Teacher getById(Integer teacherId) {
        return teacherCrudRepository.findById(teacherId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Teacher teacher, Integer id) {
        if (!Objects.equals(teacher.getId(), id))
            throw new EntityNotFoundException();
        teacherCrudRepository.save(teacher);

    }

    @Override
    @Transactional
    public void delete(Integer teacherId) {
        teacherCrudRepository.deleteById(teacherId);
    }
}
