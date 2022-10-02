package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson extends AbstractBaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(mappedBy = "lessons")
    private Set<Student> students;

    @ManyToMany(mappedBy = "lessons")
    private Set<Teacher> teachers;

    @Column(name = "value", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    private String value;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    public Lesson() {
    }

    public Lesson(Integer id, Group group, String value, LocalDate date) {
        super(id);
        this.group = group;
        this.value = value;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
