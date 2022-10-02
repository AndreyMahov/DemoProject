package com.prideTeam.AstonWebSchool.controllers.group;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.services.crud.GroupCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Контроллер обрабатывающий CRUD запросы для сущности Group.
 * Предлагаю принимать и отдавать данные в 2 форматах xml/json это делается очень легко
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr/Teacher)
 *
 * @RequestBody не обязательно помечать аргумент, для наглядности, если кто-то не знает, как работает @RestController
 * @ResponseBody не обязательно помечать метод, для наглядности, если кто-то не знает, как работает @RestController
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего, если не знаете
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = GroupCrudController.REST_URL)
public class GroupCrudController {
    static final String REST_URL = "/rest/groups";

    private final GroupCrudService groupCrudService;

    public GroupCrudController(GroupCrudService groupCrudService) {
        this.groupCrudService = groupCrudService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Group> createWithLocation(@RequestBody Group group) {
        Group created = groupCrudService.create(group);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Group get(@PathVariable Integer id) {
        return groupCrudService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Group> getAll() {
        return groupCrudService.getAll();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Group group, @PathVariable Integer id) {
        groupCrudService.update(group,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        groupCrudService.delete(id);
    }
}
