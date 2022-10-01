package com.prideTeam.AstonWebSchool.controllers.group;

import com.prideTeam.AstonWebSchool.entity.Group;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Контроллер для работы с преподавателями в контексте группы (назначения группы преподу/ снятие препода с группы и тд)
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr)
 * <p>
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего, если не знаете
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = GroupTeacherRestController.REST_URL)
public class GroupTeacherRestController {
    static final String REST_URL = "/rest/groups/{groupId}/teacher";

    @GetMapping
    public List<Group> getTeachersForGroup(@PathVariable Integer groupId) {
        return Collections.emptyList();
    }

    @PutMapping("{teacherId}")
    public void assignTeacherToGroup(@PathVariable Integer groupId, @PathVariable Integer teacherId) {

    }

    @DeleteMapping("{teacherId}")
    public void resignTeacherFromGroup(@PathVariable Integer groupId, @PathVariable Integer teacherId) {

    }
}
