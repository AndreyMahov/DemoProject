package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import com.prideTeam.AstonWebSchool.services.crud.LessonCrudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import static com.prideTeam.AstonWebSchool.testData.LessonTestData.ALL_LESSONS;
import static com.prideTeam.AstonWebSchool.testData.LessonTestData.ID;
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
        Lesson created = lessonCrudService.create(NEW_LESSON);
        Assertions.assertEquals(lessonCrudService.getById(created.getId()).toString(), created.toString());
    }

    @Test
    void createLesson_withInvalidData_constraintException() {
        Assertions.assertThrows(ConstraintViolationException .class, () -> lessonCrudService.create(NEW_LESSON_INVALID));
    }

    @Test
    void getById_existingLesson_success() {
        Assertions.assertEquals(lessonCrudService.getById(ID).toString(), LESSON_WITH_ID_1.toString());
    }

    @Test
    void getById_notExistingLesson_constraintException() {
        Assertions.assertThrows(EntityNotFoundException.class, () ->lessonCrudService.getById(NOT_EXISTING_ID));
    }

    @Test
    void getAllLessons_success() {
        Assertions.assertEquals(lessonCrudService.getAll().toString(), ALL_LESSONS.toString());
    }

    @Test
    void update_withValidData_success() {
        lessonCrudService.update(UPDATED_LESSON_WITH_ID_1, ID);
        Assertions.assertEquals(lessonCrudService.getById(ID).toString(), UPDATED_LESSON_WITH_ID_1.toString());
    }

    @Test
    void delete_byExistingId_success() {
        assertEquals(lessonCrudService.getById(ID).toString(), LESSON_WITH_ID_1.toString());
        lessonCrudService.delete(ID);
        assertThrows(EntityNotFoundException.class, () -> lessonCrudService.getById(ID));
    }

    @Test
    void delete_byNonExistingId_constraintException() {
        assertThrows(EntityNotFoundException.class, () -> lessonCrudService.getById(NOT_EXISTING_ID));
    }
}