package com.prideTeam.AstonWebSchool.web.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер обрабатывающий запросы для конкретного студента.
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Admin (Hr/Teacher).
 * Многие методы повторяются, поэтому будут разделены по параметрам. (Потенциально можно изменить,
 * если есть предложения - welcome).
 *
 * @RequestBody не обязательно помечать аргумент, для наглядности, если кто-то не знает, как работает @RestController.
 * @ResponseBody не обязательно помечать метод, для наглядности, если кто-то не знает, как работает @RestController.
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = StudentRestController.REST_URL)
public class StudentRestController {
    static final String REST_URL = "/rest/students/{id}/";

    @PatchMapping(params = "exclusion")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclude(@PathVariable Integer id) {

    }

    @PatchMapping(params = "exclusion/absences")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excludeWithNAbsences(@RequestParam int absences, @PathVariable Integer id) {

    }

    @GetMapping(params = "exclusion")
    @ResponseBody
    public boolean isExcluded(@PathVariable Integer id) {
        return false;
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPoint(@RequestParam float points, @PathVariable Integer id) {

    }

    @GetMapping(params = "rating")
    @ResponseBody
    public int getRating(@PathVariable Integer id) {
        return -1;
    }

    @PatchMapping(params = "absent=true")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void markAbsent(@PathVariable Integer id) {

    }

    @PatchMapping(params = "absent=false")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unmarkAbsent(@PathVariable Integer id) {

    }

    @PatchMapping(params = "reasonably_absent=true")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void markReasonablyAbsent(@PathVariable Integer id) {

    }

    @PatchMapping(params = "reasonably_absent=false")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unmarkReasonablyAbsent(@PathVariable Integer id) {

    }

    @GetMapping(params = "absences")
    @ResponseBody
    public int getAbsences(@PathVariable Integer id) {
        return -1;
    }

    @GetMapping(params = "reasonable_absences")
    @ResponseBody
    public int getReasonableAbsences(@PathVariable Integer id) {
        return -1;
    }
}
