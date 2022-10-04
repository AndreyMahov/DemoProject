package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Lesson;

import java.util.List;

public interface LessonCrudService {

    Lesson create(Lesson lesson);

    Lesson getById(Integer lessonId);

    List<Lesson> getAll();

    void update(Lesson lesson);

    void delete(Integer lessonId);
}
