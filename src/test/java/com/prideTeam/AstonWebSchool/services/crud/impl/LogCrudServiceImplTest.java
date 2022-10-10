package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.services.crud.LogCrudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityNotFoundException;

import static com.prideTeam.AstonWebSchool.testData.LogTestData.ALL_LOGS;
import static com.prideTeam.AstonWebSchool.testData.LogTestData.LOG;
import static com.prideTeam.AstonWebSchool.testData.LogTestData.LOG_ID;
import static com.prideTeam.AstonWebSchool.testData.LogTestData.NEW_LOG;
import static com.prideTeam.AstonWebSchool.testData.StudentTestData.STUDENT_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Import({LogCrudServiceImpl.class})
class LogCrudServiceImplTest {
    @Autowired
    private LogCrudService logCrudService;

    @Test
    void create_withValidData_success() {
        Log created = logCrudService.create(NEW_LOG, STUDENT_ID);
        assertEquals(created.toString(), logCrudService.getByLogIdAndStudentId(created.getId(), STUDENT_ID).toString());
    }

    @Test
    void getByLogIdAndStudentId_success() {
        Assertions.assertEquals(logCrudService.getByLogIdAndStudentId(LOG_ID, STUDENT_ID).toString(), LOG.toString());
    }

    @Test
    void getAll_success() {
        Assertions.assertEquals(logCrudService.getAll(STUDENT_ID).toString(), ALL_LOGS.toString());
    }

    @Test
    @Disabled // Т.к. не настроена валидация со стороны persistence
    void update() {
    }

    @Test
    void delete_success() {
        assertEquals(logCrudService.getByLogIdAndStudentId(LOG_ID, STUDENT_ID).toString(), LOG.toString());
        logCrudService.delete(LOG_ID, STUDENT_ID);
        assertThrows(EntityNotFoundException.class, () -> logCrudService.getByLogIdAndStudentId(LOG_ID, STUDENT_ID));
    }

    @Test
    void setApprove_success() {
        assertFalse(logCrudService.getByLogIdAndStudentId(LOG_ID, STUDENT_ID).getApproved());
        logCrudService.setApprove(LOG_ID, STUDENT_ID, Boolean.TRUE);
        assertTrue(logCrudService.getByLogIdAndStudentId(LOG_ID, STUDENT_ID).getApproved());
    }
}