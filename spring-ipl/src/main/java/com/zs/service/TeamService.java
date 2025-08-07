package com.zs.service;

import com.zs.entity.Team;
import com.zs.error.ResourceNotFoundException;

import java.util.List;

public interface TeamService {
    Team persist(Team team);
    void update(Team team);
    Team findById(int id) throws ResourceNotFoundException;
    List<Team> findAll();
}
