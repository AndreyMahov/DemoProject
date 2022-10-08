package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Lesson;

import java.time.LocalDate;
import java.util.List;

import static com.prideTeam.AstonWebSchool.testData.GroupTestData.NEW_GROUP;

public class LessonTestData {
    public static final Integer ID = 1;
    public static final Integer NOT_EXISTING_ID = Integer.MAX_VALUE;
    public static final Lesson NEW_LESSON = new Lesson(null, NEW_GROUP, "someValue", null);
    public static final Lesson NEW_LESSON_INVALID = new Lesson(null, NEW_GROUP, "", null);
    public static final Lesson LESSON_WITH_ID_1 = new Lesson(ID, NEW_GROUP, "value", null);
    public static final Lesson UPDATED_LESSON_WITH_ID_1 = new Lesson(ID, NEW_GROUP, "updated value", null);
    public static final List<Lesson> ALL_LESSONS = List.of(
            new Lesson(1, NEW_GROUP, "Lesson 1", null),
            new Lesson(2, NEW_GROUP, "Lesson 2", null),
            new Lesson(3, NEW_GROUP, "Lesson 3", null),
            new Lesson(4, NEW_GROUP, "Lesson 4", null),
            new Lesson(5, NEW_GROUP, "Lesson 5", null)
    );
}
