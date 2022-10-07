package com.prideTeam.AstonWebSchool.controllers.lesson;

import com.prideTeam.AstonWebSchool.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = LessonRestController.REST_URL)
public class LessonRestController {

    static final String REST_URL = "/rest/lessons/{id}/";

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Student> getPair() {
        return Collections.emptyList();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Student getRandom(@PathVariable Integer lessonId) {
        return null;
    }

}
