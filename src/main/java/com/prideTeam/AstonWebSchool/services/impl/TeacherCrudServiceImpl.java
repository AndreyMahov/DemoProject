package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Teacher;
import com.prideTeam.AstonWebSchool.repositories.RoleRepository;
import com.prideTeam.AstonWebSchool.repositories.TeacherCrudRepository;
import com.prideTeam.AstonWebSchool.services.TeacherCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeacherCrudServiceImpl implements TeacherCrudService {
    private static final String TEACHER_ROLE = "teacher";

    private final TeacherCrudRepository teacherCrudRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public TeacherCrudServiceImpl(TeacherCrudRepository teacherCrudRepository, RoleRepository roleRepository) {
        this.teacherCrudRepository = teacherCrudRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Teacher save(Teacher teacher) {
        teacher.setRole(roleRepository.findByRole(TEACHER_ROLE));
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
    public void update(Teacher teacher) {
        teacherCrudRepository.save(teacher);
    }

    @Override
    @Transactional
    public void delete(Integer teacherId) {
        teacherCrudRepository.deleteById(teacherId);
    }
}
