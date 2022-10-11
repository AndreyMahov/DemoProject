package com.prideTeam.AstonWebSchool.testData;

import com.prideTeam.AstonWebSchool.entity.Lesson;

import java.util.List;

import static com.prideTeam.AstonWebSchool.testData.GroupTestData.GROUP;

public class LessonTestData {
    public static final Integer LESSON_ID = 10007;
    public static final Lesson LESSON = new Lesson(LESSON_ID, GROUP, "Lesson 1", null);
    public static final Integer NOT_EXISTING_ID = Integer.MAX_VALUE;
    public static final Lesson NEW_LESSON = new Lesson(null, GROUP, "someValue", null);
    public static final Lesson NEW_LESSON_INVALID = new Lesson(null, GROUP, "", null);
    public static final Lesson LESSON_WITH_ID_1 = new Lesson(LESSON_ID, GROUP, "value", null);
    public static final Lesson UPDATED_LESSON_WITH_ID_1 = new Lesson(LESSON_ID, GROUP, "updated value", null);
    public static final List<Lesson> ALL_LESSONS = List.of(LESSON);
}
