package com.prideTeam.AstonWebSchool.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "lesson")
public class Lesson extends AbstractBaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private Group group;

    @Column(name = "value", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    private String value;

    @Column(name = "registered", nullable = false)
    @NotNull
    private LocalDate registered;

    public Lesson() {}

    public Lesson(Integer id, Group group, String value, LocalDate registered) {
        super(id);
        this.group = group;
        this.value = value;
        this.registered = registered;
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

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }
}
