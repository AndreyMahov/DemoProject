package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lesson_student",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lesson_teacher",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;

    @Column(name = "value", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    private String value;

    @Column(name = "registered", nullable = false, updatable = false)
    @NotNull
    private LocalDate registered;

    public Lesson() {
    }

    public Lesson(Integer id, Group group, String value, LocalDate registered) {
        super(id);
        this.group = group;
        this.value = value;
        this.registered = registered;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.getLessons().add(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.getLessons().remove(this);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getLessons().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.getLessons().remove(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate date) {
        this.registered = date;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
