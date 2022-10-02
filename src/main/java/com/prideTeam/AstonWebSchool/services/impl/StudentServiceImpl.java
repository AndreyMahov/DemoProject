package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.StudentRepository;
import com.prideTeam.AstonWebSchool.services.CrudService;
import com.prideTeam.AstonWebSchool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getById(Integer studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ExpressionException("студента с таким id нет"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void update(int id, Student student) {
        student.setId(id);
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
