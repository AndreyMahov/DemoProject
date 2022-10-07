package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "group")
public class Group extends AbstractBaseEntity {
    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    @OneToMany(mappedBy = "group")
    private Set<Lesson> lessons;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    private String name;

    @Column(name = "registered", nullable = false, updatable = false)
    @NotNull
    private LocalDate registered;

    public Group() {
    }

    public Group(Integer id, String name, LocalDate registered) {
        super(id);
        this.name = name;
        this.registered = registered;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setGroup(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setGroup(null);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        lesson.setGroup(this);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
        lesson.setGroup(null);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getGroups().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.getGroups().remove(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
