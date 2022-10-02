package com.prideTeam.AstonWebSchool.controllers.student;


import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Контроллер обрабатывающий CRUD запросы для сущности Student.
 * Предлагаю принимать и отдавать данные в 2 форматах xml/json это делается очень легко.
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr).
 *
 * @RequestBody не обязательно помечать аргумент, для наглядности, если кто-то не знает, как работает @RestController.
 * @ResponseBody не обязательно помечать метод, для наглядности, если кто-то не знает, как работает @RestController.
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего, если не знаете
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = StudentCrudRestController.REST_URL)
public class StudentCrudRestController {
    static final String REST_URL = "/rest/students/";

    private final StudentService studentService;

    public StudentCrudRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Student> createWithLocation(@RequestBody Student student) {
        Student created = null; // обращаемся к сервису
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(1).toUri(); // Тут берем id новосоздонаго лога
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Student get(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Student student, @PathVariable Integer id) {
        studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
