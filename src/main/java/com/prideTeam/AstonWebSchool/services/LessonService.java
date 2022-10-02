package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Lesson;

import java.util.List;

public interface LessonService {

    Lesson save(Lesson lesson);

    Lesson getById(Integer lessonId);

    List<Lesson> getAll();

    void update(int id, Lesson lesson);

    void delete(Integer lessonId);
}
