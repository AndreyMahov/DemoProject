package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Teacher getById(Integer teacherId);

    List<Teacher> getAll();

    void update(int id, Teacher teacher);

    void delete(Integer teacherId);
}
