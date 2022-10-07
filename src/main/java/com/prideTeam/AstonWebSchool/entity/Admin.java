package com.prideTeam.AstonWebSchool.entity;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "admin")
public class Admin extends AbstractBaseUser {
    public Admin() {
    }

    public Admin(Integer id, Role role, String email, String password, String name, String surname, LocalDate registered) {
        super(id, role, email, password, name, surname, registered);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '}';
    }
}
