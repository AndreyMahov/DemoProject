package com.prideTeam.AstonWebSchool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "group")
public class Group extends AbstractBaseEntity {
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    private String name;

    @Column(name = "registered", nullable = false)
    @NotNull
    private LocalDate registered;

    public Group() {
    }

    public Group(Integer id, String name, LocalDate registered) {
        super(id);
        this.name = name;
        this.registered = registered;
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
}
