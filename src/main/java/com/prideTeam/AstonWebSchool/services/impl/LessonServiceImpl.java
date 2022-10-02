package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import com.prideTeam.AstonWebSchool.repositories.LessonRepository;
import com.prideTeam.AstonWebSchool.services.CrudService;
import com.prideTeam.AstonWebSchool.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getById(Integer lessonId) {
        return lessonRepository.findById(lessonId).orElseThrow(() -> new ExpressionException("урока с таким id нет"));
    }

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void update(int id, Lesson lesson) {
        lesson.setId(id);
        lessonRepository.save(lesson);
    }

    @Override
    public void delete(Integer lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
