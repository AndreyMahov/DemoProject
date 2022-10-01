package com.example.prideTeam.AstonWebSchool.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Group extends AbstractEntity{

    private String name;


}
