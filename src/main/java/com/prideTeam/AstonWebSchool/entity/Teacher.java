package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher extends AbstractBaseUser {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_group",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lesson_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private Set<Lesson> lessons;

    public Teacher() {
    }

    public Teacher(Integer id, Role role, String email, String password, String name, String surname, LocalDate registered) {
        super(id, role, email, password, name, surname, registered);
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
