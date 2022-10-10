package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import com.prideTeam.AstonWebSchool.services.crud.LessonCrudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import static com.prideTeam.AstonWebSchool.testData.GroupTestData.GROUP_ID;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.ALL_LESSONS;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.LESSON_ID;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.LESSON_WITH_ID_1;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.NEW_LESSON;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.NEW_LESSON_INVALID;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.NOT_EXISTING_ID;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.UPDATED_LESSON_WITH_ID_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@Import({LessonCrudServiceImpl.class, GroupCrudServiceImpl.class})
class LessonCrudServiceImplTest {

    @Autowired
    LessonCrudService lessonCrudService;

    @Test
    void createLesson_withValidData_success() {
        Lesson created = lessonCrudService.create(NEW_LESSON, GROUP_ID);
        Assertions.assertEquals(lessonCrudService.getByLessonIdAndGroupId(created.getId(), GROUP_ID).toString(), created.toString());
    }

    @Test
    @Disabled // Т.к. не настроена валидация со стороны persistence
    void createLesson_withInvalidData_constraintException() {
        Assertions.assertThrows(ConstraintViolationException .class, () -> lessonCrudService.create(NEW_LESSON_INVALID, GROUP_ID));
    }

    @Test
    void getById_existingLesson_success() {
        Assertions.assertEquals(lessonCrudService.getByLessonIdAndGroupId(LESSON_ID, GROUP_ID).toString(), LESSON_WITH_ID_1.toString());
    }

    @Test
    void getById_notExistingLesson_constraintException() {
        Assertions.assertThrows(EntityNotFoundException.class, () ->lessonCrudService.getByLessonIdAndGroupId(NOT_EXISTING_ID, GROUP_ID));
    }

    @Test
    void getAllLessons_success() {
        Assertions.assertEquals(lessonCrudService.getAll(GROUP_ID).toString(), ALL_LESSONS.toString());
    }

    @Test
    void update_withValidData_success() {
        lessonCrudService.update(UPDATED_LESSON_WITH_ID_1, LESSON_ID, GROUP_ID);
        Assertions.assertEquals(lessonCrudService.getByLessonIdAndGroupId(LESSON_ID, GROUP_ID).toString(), UPDATED_LESSON_WITH_ID_1.toString());
    }

    @Test
    void delete_byExistingId_success() {
        assertEquals(lessonCrudService.getByLessonIdAndGroupId(LESSON_ID, GROUP_ID).toString(), LESSON_WITH_ID_1.toString());
        lessonCrudService.delete(LESSON_ID, GROUP_ID);
        assertThrows(EntityNotFoundException.class, () -> lessonCrudService.getByLessonIdAndGroupId(LESSON_ID, GROUP_ID));
    }

    @Test
    void delete_byNonExistingId_constraintException() {
        assertThrows(EntityNotFoundException.class, () -> lessonCrudService.getByLessonIdAndGroupId(NOT_EXISTING_ID, GROUP_ID));
    }
}