package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@NamedQueries({
        @NamedQuery(name = Log.SET_APPROVE_QUERY,
                query = "UPDATE Log l SET l.approved = :approved WHERE l.id = :logId AND l.student.id = :studentId")
})

@Entity
@Table(name = "log")
public class Log extends AbstractBaseEntity {
    public static final String SET_APPROVE_QUERY = "Log.setApproveQuery";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "body", nullable = false)
    @NotBlank
    @Size(min = 5, max = 72)
    private String body;

    @Column(name = "registered", nullable = false, updatable = false)
    @NotNull
    private LocalDate registered;

    @Column(name = "approved", nullable = false)
    @NotNull
    private Boolean approved;

    public Log() {
    }

    public Log(Integer id, Student student, String body, LocalDate registered, Boolean approved) {
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
