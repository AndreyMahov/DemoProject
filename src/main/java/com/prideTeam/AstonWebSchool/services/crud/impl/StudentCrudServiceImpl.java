package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.RoleCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.StudentCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.StudentCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentCrudServiceImpl implements StudentCrudService {

    private static final String STUDENT_ROLE = "student";
    private final StudentCrudRepository studentCrudRepository;
    private final RoleCrudRepository roleCrudRepository;


    public StudentCrudServiceImpl(StudentCrudRepository studentCrudRepository, RoleCrudRepository roleCrudRepository) {
        this.studentCrudRepository = studentCrudRepository;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    @Transactional
    public Student create(Student student) {
        student.setRole(roleCrudRepository.findByRole(STUDENT_ROLE));
        student.setRegistered(LocalDate.now());
        return studentCrudRepository.save(student);
    }

    @Override
    public Student getById(Integer studentId) {
        return studentCrudRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Student> getAll() {
        return studentCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Student student, int studentId) {
        if (student.getId() != studentId) {
            throw new EntityNotFoundException();
        }
        studentCrudRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(Integer studentId) {
        studentCrudRepository.deleteById(studentId);
    }
}
