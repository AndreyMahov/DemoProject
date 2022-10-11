package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Log;

import java.time.LocalDate;
import java.util.List;

import static com.prideTeam.AstonWebSchool.testData.StudentTestData.STUDENT;

public class LogTestData {
    public static final Integer LOG_ID = 10008;
    public static final Log LOG = new Log(LOG_ID, STUDENT, "Learned algorithms", null, false);
    public static final Log NEW_LOG = new Log(null, STUDENT, "Learned oop", LocalDate.now(), false);
    public static final List<Log> ALL_LOGS = List.of(LOG,
            new Log(10009, STUDENT, "Learned data structures", null, false),
            new Log(10010, STUDENT, "Learned OOP", null, false),
            new Log(10011, STUDENT, "Learned spring-core", null, false),
            new Log(10012, STUDENT, "Learned spring-data", null, false),
            new Log(10013, STUDENT, "Learned spring-com.prideTeam.AstonWebSchool.controllers", null, false)
    );
}
