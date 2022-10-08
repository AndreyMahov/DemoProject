package com.prideTeam.AstonWebSchool.controllers;

import com.prideTeam.AstonWebSchool.entity.Admin;
import com.prideTeam.AstonWebSchool.entity.Student;
import com.prideTeam.AstonWebSchool.entity.Teacher;
import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;
import com.prideTeam.AstonWebSchool.services.crud.UserCrudService;
import com.prideTeam.AstonWebSchool.services.crud.impl.UserCrudServiceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(UserCrudController.REST_URL)
public class UserCrudController {
    static final String REST_URL = "rest/users";

    private final UserCrudService userCrudService;

    public UserCrudController(UserCrudServiceImpl userCrudService) {
        this.userCrudService = userCrudService;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public AbstractBaseUser get(@PathVariable Integer id) {
        return userCrudService.getById(id);
    }

    @PostMapping(params = "type=admin",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<AbstractBaseUser> createAdminWithLocation(@RequestBody Admin admin, @RequestParam String role) {
        return makeResponseEntityForCreatedUser(userCrudService.create(admin, role));
    }

    @PostMapping(params = "type=teacher",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AbstractBaseUser> createTeacherWithLocation(@RequestBody Teacher teacher, @RequestParam String role) {
        return makeResponseEntityForCreatedUser(userCrudService.create(teacher, role));
    }

    @PostMapping(params = "type=student",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AbstractBaseUser> createStudentWithLocation(@RequestBody Student student, @RequestParam String role) {
        return makeResponseEntityForCreatedUser(userCrudService.create(student, role));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AbstractBaseUser> getAll() {
        return userCrudService.getAll();
    }

    @PutMapping(value = "/{id}", params = "type=admin",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAdmin(@RequestBody Admin admin, @PathVariable Integer id) {
        userCrudService.update(admin, id);
    }

    @PutMapping(value = "/{id}", params = "type=teacher",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer id) {
        userCrudService.update(teacher, id);
    }

    @PutMapping(value = "/{id}", params = "type=student",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        userCrudService.update(student, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userCrudService.delete(id);
    }

    private ResponseEntity<AbstractBaseUser> makeResponseEntityForCreatedUser(AbstractBaseUser created){
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
