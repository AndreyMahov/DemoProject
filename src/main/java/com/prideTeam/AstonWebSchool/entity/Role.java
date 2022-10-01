package com.prideTeam.AstonWebSchool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
public class Role extends AbstractBaseEntity {
    @Column(name = "role", nullable = false)
    @NotBlank
    @Size(min = 1, max = 64)
    private String role;

    public Role() {}

    public Role(Integer id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
