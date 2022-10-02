package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.repositories.GroupRepository;
import com.prideTeam.AstonWebSchool.services.CrudService;
import com.prideTeam.AstonWebSchool.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getById(Integer groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new ExpressionException("группы с таким id нет"));
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public void update(int id, Group group) {

    }

    @Override
    public void delete(Integer groupId) {

    }
}
