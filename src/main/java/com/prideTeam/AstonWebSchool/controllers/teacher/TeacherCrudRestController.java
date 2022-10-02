package com.prideTeam.AstonWebSchool.controllers.teacher;

import com.prideTeam.AstonWebSchool.entity.Teacher;
import com.prideTeam.AstonWebSchool.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Контроллер обрабатывающий CRUD запросы для сущности Teacher.
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr).
 * <p>
 * Предлагаю принимать и отдавать данные в 2 форматах xml/json это делается очень легко.
 *
 * @RequestBody не обязательно помечать аргумент, для наглядности, если кто-то не знает, как работает @RestController.
 * @ResponseBody не обязательно помечать метод, для наглядности, если кто-то не знает, как работает @RestController.
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = TeacherCrudRestController.REST_URL)
public class TeacherCrudRestController {
    static final String REST_URL = "/rest/teachers/";

    private final TeacherService teacherService;

    @Autowired
    public TeacherCrudRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Teacher> createWithLocation(@RequestBody Teacher teacher) {
        Teacher created = teacherService.save(teacher); // обращаемся к сервису
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri(); // Тут берем id новосоздоной группы
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "{teacherId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Teacher get(@PathVariable Integer teacherId) {
        return teacherService.getById(teacherId);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @PutMapping(value = "{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Teacher teacher) {
        teacherService.update(id, teacher);
    }

    @DeleteMapping("{teacherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer teacherId) {
        teacherService.delete(teacherId);
    }
}
