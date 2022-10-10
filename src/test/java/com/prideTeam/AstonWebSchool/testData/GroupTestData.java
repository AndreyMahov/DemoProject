package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Group;

import java.time.LocalDate;

public class GroupTestData {
    public static final Integer GROUP_ID = 10000;
    public static final Group GROUP = new Group(GROUP_ID, "groupName", LocalDate.now());
}
