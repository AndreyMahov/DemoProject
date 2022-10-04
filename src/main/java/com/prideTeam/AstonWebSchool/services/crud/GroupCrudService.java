package com.prideTeam.AstonWebSchool.services.crud;

import com.prideTeam.AstonWebSchool.entity.Group;

import java.util.List;

public interface GroupCrudService {
    Group create(Group group);

    Group getById(Integer groupId);

    List<Group> getAll();

    void update(Group group, Integer id);

    void delete(Integer groupId);
}
