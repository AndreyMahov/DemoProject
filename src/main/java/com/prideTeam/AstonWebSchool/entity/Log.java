package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "log")
public class Log extends AbstractBaseEntity {
    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "body", nullable = false)
    @NotBlank
    @Size(min = 5, max = 72)
    private String body;

    @Column(name = "registered", nullable = false, updatable = false)
    @NotNull
    private LocalDate registered;

    public Log() {
    }

    public Log(Integer id, Student student, String body, LocalDate registered) {
        super(id);
        this.student = student;
        this.body = body;
        this.registered = registered;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate date) {
        this.registered = date;
    }
}
