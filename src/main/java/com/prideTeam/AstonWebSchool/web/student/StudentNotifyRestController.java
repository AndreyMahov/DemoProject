package com.prideTeam.AstonWebSchool.web.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер обрабатывающий запросы для нотификации студента. (Потенциальная точка расширения (Дз ...).
 * Доступ можно определеять по uri, т.е. к данному контроллеру будет иметь доступ Student.
 * <p>
 * TODO: Обязательно почитайте про каждую аннотацию, что делает и для чего, если не знаете
 * TODO: Обязательно!!! Если нашли ошибку или считаете, что есть что добавить скажите мне
 * TODO: Сделать полноценную реализацию контроллера
 */

@RestController
@RequestMapping(value = StudentRestController.REST_URL)
public class StudentNotifyRestController {
    static final String REST_URL = "/rest/students/{id}/notify/";

    /**
     * Если нужно уведомить - возвращаем сгенерированное сообщение
     * Если нет - возвращаем NO_RESPONSE
     */
    public void logNotification() {

    }

    /**
     * Если нужно уведомить - возвращаем сгенерированное сообщение
     * Если нет - возвращаем NO_RESPONSE
     */
    public void ratingNotification() {

    }

}
