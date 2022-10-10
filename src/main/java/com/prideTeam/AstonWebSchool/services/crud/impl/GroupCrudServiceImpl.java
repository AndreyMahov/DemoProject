package com.prideTeam.AstonWebSchool.services.crud.impl;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.repositories.crud.GroupCrudRepository;
import com.prideTeam.AstonWebSchool.services.crud.GroupCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class GroupCrudServiceImpl implements GroupCrudService {
    private final GroupCrudRepository groupCrudRepository;

    public GroupCrudServiceImpl(GroupCrudRepository groupCrudRepository) {
        this.groupCrudRepository = groupCrudRepository;
    }

    @Override
    @Transactional
    public Group create(Group group) {
        group.setRegistered(LocalDate.now());
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
    public void update(Group group, Integer id) {
        if (!Objects.equals(group.getId(), id))
            throw new EntityNotFoundException();
        groupCrudRepository.save(group);
    }

    @Override
    @Transactional
    public void delete(Integer groupId) {
        groupCrudRepository.delete(groupCrudRepository.getReferenceById(groupId));
    }
}
