package com.prideTeam.AstonWebSchool.repositories.crud;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonCrudRepository extends JpaRepository<Lesson, Integer> {
    Optional<Lesson> findByIdAndGroupId(Integer id, Integer groupId);

    List<Lesson> findAllByGroupId(Integer groupId);

    int deleteByIdAndGroupId(Integer lessonId, Integer groupId);
}
