package com.example.prideTeam.AstonWebSchool.domain.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
public class Student extends AbstractUser {

    private int group_id;

    private int points;

    private int absences;

    private int reasonable_absences;

    private boolean excluded;
}
