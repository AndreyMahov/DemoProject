package com.example.prideTeam.AstonWebSchool.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@Data
public abstract class AbstractUser extends AbstractEntity {
 private String name;

    private String surname;

    private String email;

    private String password;




}
