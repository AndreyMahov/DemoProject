package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Group;

import java.util.List;

public interface GroupService {
    Group save(Group group);

    Group getById(Integer groupId);

    List<Group> getAll();

    void update(int id,Group group);

    void delete(Integer groupId);
}
