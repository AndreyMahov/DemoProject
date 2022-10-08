package com.prideTeam.AstonWebSchool.entity.entityAbstracts;

//import com.prideTeam.AstonWebSchool.View;
import com.prideTeam.AstonWebSchool.entity.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class AbstractBaseUser extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    protected Role role;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 254)
    protected String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 64)
    protected String password;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 64)
    protected String name;

    @Column(name = "surname", nullable = false)
    @NotBlank
    @Size(min = 2, max = 64)
    protected String surname;

    @Column(name = "registered", nullable = false, updatable = false, insertable = false)
//    @NotNull(groups = View.Persist.class)
    protected LocalDate registered;

    protected AbstractBaseUser() {
    }

    public AbstractBaseUser(Integer id, Role role, String email, String password, String name, String surname, LocalDate registered) {
        super(id);
        this.role = role;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.registered = registered;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }
}
