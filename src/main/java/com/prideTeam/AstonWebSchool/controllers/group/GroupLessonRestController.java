package com.prideTeam.AstonWebSchool.controllers.group;

import com.prideTeam.AstonWebSchool.entity.Lesson;
import com.prideTeam.AstonWebSchool.services.crud.LessonCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Контроллер обрабатывающий CRUD запросы для сущности Lesson.
 * Lesson всегда существует в контексте группы
 */

@RestController
@RequestMapping(value = GroupLessonRestController.REST_URL)
public class GroupLessonRestController {
    static final String REST_URL = "/rest/groups/{groupId}/lessons";

    private final LessonCrudService lessonCrudService;

    public GroupLessonRestController(LessonCrudService lessonCrudService) {
        this.lessonCrudService = lessonCrudService;
    }

    @PostMapping
    public ResponseEntity<Lesson> createWithLocation(@RequestBody Lesson lesson, @PathVariable Integer groupId) {
        Lesson created = lessonCrudService.create(lesson, groupId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/lessonId")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{lessonId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Lesson get(@PathVariable Integer lessonId, @PathVariable Integer groupId) {
        return lessonCrudService.getByLessonIdAndGroupId(lessonId, groupId);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Lesson> getAll(@PathVariable Integer groupId) {
        return lessonCrudService.getAll(groupId);
    }

    @PutMapping(value = "/{lessonId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Lesson lesson, @PathVariable Integer lessonId, @PathVariable Integer groupId) {
        lessonCrudService.update(lesson, lessonId, groupId);
    }

    @DeleteMapping("/{lessonId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer lessonId, @PathVariable Integer groupId) {
        lessonCrudService.delete(lessonId, groupId);
    }
}
