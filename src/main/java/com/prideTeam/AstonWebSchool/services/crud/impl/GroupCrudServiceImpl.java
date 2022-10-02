package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.repositories.GroupCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.GroupCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class GroupCrudServiceImpl implements GroupCrudService {

    private final GroupCrudRepository groupCrudRepository;

    @Autowired
    public GroupCrudServiceImpl(GroupCrudRepository groupCrudRepository) {
        this.groupCrudRepository = groupCrudRepository;
    }


    @Override
    @Transactional
    public Group create(Group group) {
        return groupCrudRepository.save(group);
    }

    @Override
    public Group getById(Integer groupId) {
        return groupCrudRepository.findById(groupId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Group> getAll() {
        return groupCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Group group, Integer groupId) {
        if (group.getId().equals(groupId))
            groupCrudRepository.save(group);
        else throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void delete(Integer groupId) {
        groupCrudRepository.deleteById(groupId);
    }
}
