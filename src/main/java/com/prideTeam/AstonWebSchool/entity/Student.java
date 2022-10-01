package com.prideTeam.AstonWebSchool.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student extends AbstractBaseUser {
    @OneToOne(fetch = FetchType.LAZY)
    private Group group;

    @Column(name = "points", nullable = false)
    @NotNull
    @PositiveOrZero
    private Float points;

    @Column(name = "absences", nullable = false)
    @NotNull
    @PositiveOrZero
    private Integer absences;

    @Column(name = "reasonable_absences", nullable = false)
    @NotNull
    @PositiveOrZero
    private Integer reasonableAbsences;

    @Column(name = "excluded", nullable = false)
    @NotNull
    private Boolean excluded;

    public Student() {}

    public Student(Integer id, Role role, String email, String password, String name, String surname, LocalDate registered,
                   Group group, Float points, Integer absences, Integer reasonableAbsences, Boolean excluded) {
        super(id, role, email, password, name, surname, registered);
        this.group = group;
        this.points = points;
        this.absences = absences;
        this.reasonableAbsences = reasonableAbsences;
        this.excluded = excluded;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public Integer getAbsences() {
        return absences;
    }

    public void setAbsences(Integer absences) {
        this.absences = absences;
    }

    public Integer getReasonableAbsences() {
        return reasonableAbsences;
    }

    public void setReasonableAbsences(Integer reasonableAbsences) {
        this.reasonableAbsences = reasonableAbsences;
    }

    public Boolean getExcluded() {
        return excluded;
    }

    public void setExcluded(Boolean excluded) {
        this.excluded = excluded;
    }
}