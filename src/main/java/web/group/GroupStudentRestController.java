package web.group;

import entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Контроллер обрабатывающий запросы на работу со студентом (добавление/удаление/исключение и тд).
 * <p>
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr/Teacher).
 * Предлагаю принимать и отдавать данные в 2 форматах xml/json это делается очень легко.
 *
 * @ResponseBody не обязательно помечать метод, для наглядности, если кто-то не знает, как работает @RestController.
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего, если не знаете
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = GroupStudentRestController.REST_URL)
public class GroupStudentRestController {
    static final String REST_URL = "/rest/groups/{groupId}/students";

    @PutMapping("/{studentId}")
    public void addStudent(@PathVariable Integer groupId, @PathVariable Integer studentId) {

    }

    @DeleteMapping("/{studentId}")
    public void removeStudent(@PathVariable Integer groupId, @PathVariable Integer studentId) {

    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Student> getStudents(@PathVariable Integer groupId) {
        return Collections.emptyList();
    }
}
