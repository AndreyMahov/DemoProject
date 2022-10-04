package com.prideTeam.AstonWebSchool.controllers.teacher;

import com.prideTeam.AstonWebSchool.entity.Teacher;
import com.prideTeam.AstonWebSchool.services.TeacherCrudService;
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
 */

@RestController
@RequestMapping(value = TeacherCrudRestController.REST_URL)
public class TeacherCrudRestController {
    static final String REST_URL = "/rest/teachers";

    private final TeacherCrudService teacherCrudService;

    @Autowired
    public TeacherCrudRestController(TeacherCrudService teacherCrudService) {
        this.teacherCrudService = teacherCrudService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Teacher> createWithLocation(@RequestBody Teacher teacher) {
        Teacher created = teacherCrudService.save(teacher);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Teacher get(@PathVariable Integer id) {
        return teacherCrudService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Teacher> getAll() {
        return teacherCrudService.getAll();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(Teacher teacher, @PathVariable Integer id) {
        teacherCrudService.update(teacher, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        teacherCrudService.delete(id);
    }
}
