package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import com.prideTeam.AstonWebSchool.repositories.crud.GroupCrudRepository;
import com.prideTeam.AstonWebSchool.repositories.crud.LessonCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.LessonCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class LessonCrudServiceImpl implements LessonCrudService {

    private final LessonCrudRepository lessonCrudRepository;
    private final GroupCrudRepository groupCrudRepository;

    public LessonCrudServiceImpl(LessonCrudRepository lessonCrudRepository, GroupCrudRepository groupCrudRepository) {
        this.lessonCrudRepository = lessonCrudRepository;
        this.groupCrudRepository = groupCrudRepository;
    }

    @Override
    @Transactional
    public Lesson create(Lesson lesson, Integer groupId) {
        lesson.setRegistered(LocalDate.now());
        lesson.setGroup(groupCrudRepository.getReferenceById(groupId));
        return lessonCrudRepository.save(lesson);
    }

    @Override
    public Lesson getByLessonIdAndGroupId(Integer lessonId, Integer groupId) {
        return lessonCrudRepository.findByIdAndGroupId(lessonId, groupId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Lesson> getAll(Integer groupId) {
        return lessonCrudRepository.findAllByGroupId(groupId);
    }

    @Override
    @Transactional
    public void update(Lesson lesson, Integer lessonId, Integer groupId) {
        if (!Objects.equals(lesson.getId(), lessonId)) {
            throw new EntityNotFoundException();
        }
        Lesson updated = lessonCrudRepository.findByIdAndGroupId(lessonId, groupId).orElseThrow(EntityNotFoundException::new);
        //TODO: РЕАЛИЗОВАТЬ update. На данный момент при обновлениии части полей, перезаписываются все данные
        //TODO: Это плохо, надо менять
    }

    @Override
    @Transactional
    public void delete(Integer lessonId, Integer groupId) {
        if (lessonCrudRepository.deleteByIdAndGroupId(lessonId, groupId) == 0)
            throw new EntityNotFoundException();
    }
}
