package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Group;

import java.time.LocalDate;

public class GroupTestData {

    public static final Group NEW_GROUP = new Group(1, "groupName", LocalDate.now());
}
