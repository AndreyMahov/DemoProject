package com.prideTeam.AstonWebSchool.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "teacher")
public class Admin extends AbstractBaseUser {
    public Admin() {
    }

    public Admin(Integer id, Role role, String email, String password, String name, String surname, LocalDate registered) {
        super(id, role, email, password, name, surname, registered);
    }
}
