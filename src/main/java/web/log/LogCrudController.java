package web.log;

import entity.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Контроллер обрабатывающий CRUD запросы для сущности Log.
 * Лог является сущностью, принадлежащей Студенту, поэтому все операции с логом, выполняются в контексте студента (см uri).
 * Предлагаю принимать и отдавать данные в 2 форматах xml/json это делается очень легко.
 * Доступ к каждому методу будет контролироваться за счет: spring security method level security.
 * Изначально хотел секьюрить по uri, но вроде так не получится.
 *
 * @RequestBody не обязательно помечать аргумент, для наглядности, если кто-то не знает, как работает @RestController
 * @ResponseBody не обязательно помечать метод, для наглядности, если кто-то не знает, как работает @RestController
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего, если не знаете
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */
@RestController
@RequestMapping(value = LogCrudController.REST_URL)
public class LogCrudController {
    static final String REST_URL = "/rest/students/{studentId}/logs";

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Log> createWithLocation(@RequestBody Log log, @PathVariable Integer studentId) {
        Log created = null; // обращаемся к сервису
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(1).toUri(); // Тут берем id новосоздонаго лога
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{logId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Log get(@PathVariable Integer logId, @PathVariable Integer studentId) {
        return null;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Log> getAll(@PathVariable Integer studentId) {
        return Collections.emptyList();
    }

    @PutMapping(value = "/{logId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Log log, @PathVariable Integer logId, @PathVariable Integer studentId) {

    }

    @DeleteMapping("/{logId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer logId, @PathVariable Integer studentId) {

    }
}
