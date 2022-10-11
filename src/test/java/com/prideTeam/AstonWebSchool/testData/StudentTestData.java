package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Student;

import static com.prideTeam.AstonWebSchool.testData.GroupTestData.GROUP;
import static com.prideTeam.AstonWebSchool.testData.RoleTestData.STUDENT_ROLE;

public class StudentTestData {
    public static final Integer STUDENT_ID = 10006;
    public static final Student STUDENT = new Student(STUDENT_ID, STUDENT_ROLE, "student_frank@gmail.com",
            "password", "Frank", "studentov", null, GROUP, 0.0f, 0,
            0, false);
}