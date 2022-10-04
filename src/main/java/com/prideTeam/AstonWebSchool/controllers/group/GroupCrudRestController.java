package com.prideTeam.AstonWebSchool.controllers.group;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.services.crud.GroupCrudService;
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
 * Контроллер обрабатывающий CRUD запросы для сущности Group.
 * Доступ можно определять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr/Teacher)
 */

@RestController
@RequestMapping(value = GroupCrudRestController.REST_URL)
public class GroupCrudRestController {
    static final String REST_URL = "/rest/groups";
    private final GroupCrudService groupCrudService;

    public GroupCrudRestController(GroupCrudService groupCrudService) {
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
        groupCrudService.update(group, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        groupCrudService.delete(id);
    }
}
