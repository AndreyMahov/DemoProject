package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Lesson;

import java.util.List;

public interface LessonCrudService {

    Lesson create(Lesson lesson, Integer groupId);

    Lesson getByLessonIdAndGroupId(Integer lessonId, Integer groupId);

    List<Lesson> getAll(Integer groupId);

    void update(Lesson lesson, Integer lessonId, Integer groupId);

    void delete(Integer lessonId, Integer groupId);
}
