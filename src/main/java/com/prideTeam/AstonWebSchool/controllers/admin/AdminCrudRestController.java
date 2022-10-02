package com.prideTeam.AstonWebSchool.controllers.admin;


import com.prideTeam.AstonWebSchool.entity.Admin;
import com.prideTeam.AstonWebSchool.services.AdminCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Контроллер обрабатывающий CRUD запросы для сущности Admin.
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin.
 */

@RestController
@RequestMapping(value = AdminCrudRestController.REST_URL)
public class AdminCrudRestController {
    static final String REST_URL = "/rest/admins";

    private final AdminCrudService adminCrudService;

    public AdminCrudRestController(AdminCrudService adminCrudService) {
        this.adminCrudService = adminCrudService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Admin> createWithLocation(@RequestBody Admin admin) {
        Admin created = adminCrudService.save(admin);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Admin get(@PathVariable Integer id) {
        return adminCrudService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Admin> getAll() {
        return adminCrudService.getAll();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Admin admin, @PathVariable Integer id) {
        adminCrudService.update(admin, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        adminCrudService.delete(id);
    }
}
