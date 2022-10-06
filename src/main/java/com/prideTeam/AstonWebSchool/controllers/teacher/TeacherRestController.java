package com.prideTeam.AstonWebSchool.controllers.teacher;

import com.prideTeam.AstonWebSchool.entity.Group;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Контроллер обрабатывающий запросы для конкретного преподователя. (Потенциальная точка расширения (Дз ...)
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Teacher)
 * <p>
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */
@RestController
@RequestMapping(value = TeacherRestController.REST_URL)
public class TeacherRestController {
    static final String REST_URL = "/rest/teachers/{teacherId}/";

    @GetMapping("groups")
    public List<Group> getGroupsForTeacher(@PathVariable Integer teacherId) {
        return Collections.emptyList();
    }

    // добавить балл студенту
    // просмотреть логи студента

}
