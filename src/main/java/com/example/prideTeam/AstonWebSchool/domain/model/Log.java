package com.example.prideTeam.AstonWebSchool.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Log extends AbstractEntity {

    private int student_id;

    private String body;

    private Date date;
}
