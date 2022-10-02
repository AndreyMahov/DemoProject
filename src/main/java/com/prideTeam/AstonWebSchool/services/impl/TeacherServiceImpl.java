package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Role;
import com.prideTeam.AstonWebSchool.entity.Teacher;
import com.prideTeam.AstonWebSchool.repositories.TeacherRepository;
import com.prideTeam.AstonWebSchool.services.CrudService;
import com.prideTeam.AstonWebSchool.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        teacher.setRegistered(LocalDate.now());
        teacher.setRole(new Role(1, "teacher"));
        return teacherRepository.save(teacher);
    }

    @Override
    @Transactional(readOnly = true)
    public Teacher getById(Integer teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow(() -> new ExpressionException("учителя с таким id нет"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teacher> getAll() {

        return teacherRepository.findAll();
    }

    @Override
    public void update(int id, Teacher teacher) {
        teacher.setId(id);
        teacher.setRegistered(LocalDate.now());
        teacher.setRole(new Role(1, "teacher"));
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Integer teacherId) {
        teacherRepository.deleteById(teacherId);
    }


}
