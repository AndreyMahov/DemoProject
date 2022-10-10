package com.prideTeam.AstonWebSchool.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static com.prideTeam.AstonWebSchool.testData.GroupTestData.GROUP;
import static com.prideTeam.AstonWebSchool.testData.TeacherTestData.TEACHER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({TeacherGroupServiceImpl.class})
class TeacherGroupServiceImplTest {
    @Autowired
    private TeacherGroupService teacherGroupService;

    @Test
    void getGroupsForTeacher() {
        assertEquals(teacherGroupService.getGroupsForTeacher(TEACHER_ID).toString(), List.of(GROUP).toString());
    }
}