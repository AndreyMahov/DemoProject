package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student getById(Integer studentId);

    List<Student> getAll();

    void update(Student student);

    void delete(Integer studentId);
}
