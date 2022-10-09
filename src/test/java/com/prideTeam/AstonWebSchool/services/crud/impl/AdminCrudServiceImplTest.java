package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.Profiles;
import com.prideTeam.AstonWebSchool.entity.Admin;
//import com.prideTeam.AstonWebSchool.services.crud.AdminCrudService;
import com.prideTeam.AstonWebSchool.services.crud.RoleCrudService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import static com.prideTeam.AstonWebSchool.testData.AdminTestData.ADMIN_WITH_1_ID;
import static com.prideTeam.AstonWebSchool.testData.AdminTestData.ALL_ADMINS;
import static com.prideTeam.AstonWebSchool.testData.AdminTestData.ID;
import static com.prideTeam.AstonWebSchool.testData.AdminTestData.NEW_ADMIN;
import static com.prideTeam.AstonWebSchool.testData.AdminTestData.NEW_ADMIN_WITH_INVALID_DATA;
import static com.prideTeam.AstonWebSchool.testData.AdminTestData.NOT_EXISTING_ID;
import static com.prideTeam.AstonWebSchool.testData.AdminTestData.UPDATED_ADMIN_WITH_1_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
//@Import({AdminCrudServiceImpl.class, RoleCrudServiceImpl.class})
@ActiveProfiles(Profiles.DEV_PROFILE)
class AdminCrudServiceImplTest {
//    @Autowired
//    AdminCrudService adminCrudService;
//
//    @Autowired
//    RoleCrudService roleCrudService;
//
//    @Test
//    void createAdmin_adminWithValidData_success() {
//        Admin created = adminCrudService.create(NEW_ADMIN);
//        assertEquals(adminCrudService.getById(created.getId()).toString(), created.toString());
//    }
//
//    @Test
//    void createAdmin_adminWithInvalidData_constraintException() {
//        assertThrows(ConstraintViolationException.class, () -> adminCrudService.create(NEW_ADMIN_WITH_INVALID_DATA));
//    }
//
//    @Test
//    void getById_withExistingId_success() {
//        assertEquals(adminCrudService.getById(ID).toString(), ADMIN_WITH_1_ID.toString());
//    }
//
//    @Test
//    void getById_withNotExistingId_success() {
//        assertThrows(EntityNotFoundException.class, () -> adminCrudService.getById(NOT_EXISTING_ID));
//    }
//
//    @Test
//    void getAll_success() {
//        assertEquals(adminCrudService.getAll().toString(), ALL_ADMINS.toString());
//    }
//
//    @Test
//    void update_withValidData_success() {
//        adminCrudService.update(UPDATED_ADMIN_WITH_1_ID, ID);
//        assertEquals(adminCrudService.getById(ID).toString(), UPDATED_ADMIN_WITH_1_ID.toString());
//    }
//
//    @Test
//    void delete_byExistingId_success() {
//        assertEquals(adminCrudService.getById(ID).toString(), ADMIN_WITH_1_ID.toString());
//        adminCrudService.delete(ID);
//        assertThrows(EntityNotFoundException.class, () -> adminCrudService.getById(ID));
//    }
//
//    @Test
//    void delete_byNotExistingId_notFoundException() {
//        assertThrows(EntityNotFoundException.class, () -> adminCrudService.getById(NOT_EXISTING_ID));
//    }
}