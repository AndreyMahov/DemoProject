package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Admin;

import java.time.LocalDate;
import java.util.List;

import static com.prideTeam.AstonWebSchool.testData.RoleTestData.ADMIN_ROLE;

public class AdminTestData {
    public static final Integer ID = 1;
    public static final Integer NOT_EXISTING_ID = Integer.MAX_VALUE;
    public static final Admin NEW_ADMIN = new Admin(null, ADMIN_ROLE, "admin_test@gmail.com",
            "password", "name", "surname", LocalDate.now());
    public static final Admin ADMIN_WITH_1_ID = new Admin(ID, ADMIN_ROLE, "admin_ivan@gmail.com",
            "password", "Ivan", "adminovich", null);
    public static final Admin UPDATED_ADMIN_WITH_1_ID = new Admin(ID, ADMIN_ROLE, "updated_ivan@gmail.com",
            "password", "updated", "updated", null);
    public static final Admin NEW_ADMIN_WITH_INVALID_DATA = new Admin(null, ADMIN_ROLE, "invalid",
            "", "", "", null);
    public static final Admin UPDATED_ADMIN_WITH_INVALID_DATA = new Admin(NOT_EXISTING_ID, ADMIN_ROLE, "invalid",
            "", "", "", null);

    public static final List<Admin> ALL_ADMINS = List.of(ADMIN_WITH_1_ID, new Admin(2, ADMIN_ROLE, "admin_steve@gmail.com",
            "password", "Steve", "adminovich", null));
}
