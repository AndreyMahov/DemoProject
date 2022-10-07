package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher extends AbstractBaseUser {
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    private Set<Group> groups;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
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
