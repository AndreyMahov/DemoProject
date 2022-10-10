package com.prideTeam.AstonWebSchool.controllers.teacher;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.services.TeacherGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер обрабатывающий запросы для конкретного преподователя и его групп.
 */
@RestController
@RequestMapping(value = TeacherGroupRestController.REST_URL)
public class TeacherGroupRestController {
    static final String REST_URL = "/rest/teachers/{teacherId}/groups";

    private final TeacherGroupService teacherGroupService;

    public TeacherGroupRestController(TeacherGroupService teacherGroupService) {
        this.teacherGroupService = teacherGroupService;
    }

    @GetMapping
    public List<Group> getGroupsForTeacher(@PathVariable Integer teacherId) {
        return teacherGroupService.getGroupsForTeacher(teacherId);
    }
}
