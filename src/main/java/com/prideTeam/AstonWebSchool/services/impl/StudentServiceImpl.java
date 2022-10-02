package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.repositories.RoleRepository;
import com.prideTeam.AstonWebSchool.repositories.StudentRepository;
import com.prideTeam.AstonWebSchool.services.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final String STUDENT_ROLE = "student";
    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;


    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Student save(Student student) {
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
    public void update(Student student, int studentId) {
        if (student.getId() != studentId) {
            throw new EntityNotFoundException();
        }
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
