package com.prideTeam.AstonWebSchool.services;

import com.prideTeam.AstonWebSchool.entity.Group;

import java.util.List;

public interface GroupCrudService {
    Group save(Group group);

    Group getById(Integer groupId);

    List<Group> getAll();

    void update(Group group, Integer id);

    void delete(Integer groupId);
}
