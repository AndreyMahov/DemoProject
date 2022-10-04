package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.RoleRepository;
import com.prideTeam.AstonWebSchool.repositories.StudentRepository;
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
    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;


    public StudentCrudServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Student create(Student student) {
        student.setRole(roleRepository.findByRole(STUDENT_ROLE));
        student.setRegistered(LocalDate.now());
        return studentRepository.save(student);
    }

    @Override
    public Student getById(Integer studentId) {
        return studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Student student, int studentId) {
        if (student.getId() != studentId) {
            throw new EntityNotFoundException();
        }
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
