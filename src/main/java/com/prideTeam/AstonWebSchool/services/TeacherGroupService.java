package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Group;

import java.util.List;

public interface TeacherGroupService {
    List<Group> getGroupsForTeacher(Integer teacherId);
}
