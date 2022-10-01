package com.example.prideTeam.AstonWebSchool.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Lesson extends AbstractEntity {

    private int group_id;

    private String value;

    private Date date;
}
