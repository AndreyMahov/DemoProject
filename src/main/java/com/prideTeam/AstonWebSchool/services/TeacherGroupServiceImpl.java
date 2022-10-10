package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.repositories.TeacherGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class TeacherGroupServiceImpl implements TeacherGroupService {
    private final TeacherGroupRepository teacherGroupRepository;

    public TeacherGroupServiceImpl(TeacherGroupRepository teacherGroupRepository) {
        this.teacherGroupRepository = teacherGroupRepository;
    }

    public List<Group> getGroupsForTeacher(Integer teacherId) {
        return teacherGroupRepository.findGroupsByTeachersId(teacherId);
    }
}
