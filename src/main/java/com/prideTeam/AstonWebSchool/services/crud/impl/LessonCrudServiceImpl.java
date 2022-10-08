package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import com.prideTeam.AstonWebSchool.repositories.LessonCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.LessonCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class LessonCrudServiceImpl implements LessonCrudService {

    private final LessonCrudRepository lessonCrudRepository;

    public LessonCrudServiceImpl(LessonCrudRepository lessonCrudRepository) {
        this.lessonCrudRepository = lessonCrudRepository;
    }

    @Override
    @Transactional
    public Lesson create(Lesson lesson) {
        lesson.setRegistered(LocalDate.now());
        return lessonCrudRepository.save(lesson);
    }

    @Override
    public Lesson getById(Integer lessonId) {
        return lessonCrudRepository.findById(lessonId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Lesson> getAll() {
        return lessonCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Lesson lesson, Integer lessonId) {
        if (!Objects.equals(lesson.getId(), lessonId)) {
            throw new EntityNotFoundException();
        }
        lessonCrudRepository.save(lesson);
    }

    @Override
    @Transactional
    public void delete(Integer lessonId) {
        lessonCrudRepository.deleteById(lessonId);
    }
}
