package com.prideTeam.AstonWebSchool.services.impl;

import com.prideTeam.AstonWebSchool.entity.Group;
import com.prideTeam.AstonWebSchool.repositories.GroupCrudRepository;
import com.prideTeam.AstonWebSchool.services.GroupCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class GroupCrudServiceImpl implements GroupCrudService {
    private final GroupCrudRepository repo;

    public GroupCrudServiceImpl(GroupCrudRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Group save(Group group) {
        group.setRegistered(LocalDate.now());
        return repo.save(group);
    }

    @Override
    public Group getById(Integer groupId) {
        return repo.findById(groupId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Group> getAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void update(Group group, Integer id) {
        if (!Objects.equals(group.getId(), id))
            throw new EntityNotFoundException();
        repo.save(group);
    }

    @Override
    @Transactional
    public void delete(Integer groupId) {
        repo.delete(repo.getReferenceById(groupId));
    }
}
