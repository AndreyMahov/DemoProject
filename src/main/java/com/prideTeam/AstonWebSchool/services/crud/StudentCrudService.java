package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Student;

import java.util.List;

public interface StudentCrudService {
    Student create(Student student);

    Student getById(Integer studentId);

    List<Student> getAll();

    void update(Student student, int studentId);

    void delete(Integer studentId);
}
