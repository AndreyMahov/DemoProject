package com.prideTeam.AstonWebSchool.controllers.log;

import com.prideTeam.AstonWebSchool.entity.Log;
import com.prideTeam.AstonWebSchool.services.crud.LogCrudService;
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

@RestController
@RequestMapping(value = LogCrudRestController.REST_URL)
public class LogCrudRestController {
    static final String REST_URL = "/rest/students/{studentId}/logs";

    private final LogCrudService logService;

    public LogCrudRestController(LogCrudService logService) {
        this.logService = logService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Log> createWithLocation(@RequestBody Log log, @PathVariable Integer studentId) {
        Log created = logService.create(log, studentId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{logId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Log get(@PathVariable Integer logId, @PathVariable Integer studentId) {
        return logService.getById(logId, studentId);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Log> getAll(@PathVariable Integer studentId) {
        return logService.getAll(studentId);
    }

    @PutMapping(value = "/{logId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Log log, @PathVariable Integer studentId) {
        logService.update(log, studentId);
    }

    @DeleteMapping("/{logId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer logId, @PathVariable Integer studentId) {
        logService.delete(logId, studentId);
    }
}
