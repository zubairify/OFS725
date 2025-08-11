package com.zs.service;

import com.zs.entity.Team;
import com.zs.error.ResourceNotFoundException;
import com.zs.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Value("${app.max.budget}")
    private double max_budget;

    @Autowired
    private TeamRepository repo;

    @Override
    public Team persist(Team team) {
        team.setBudget(max_budget);
        return repo.save(team);
    }

    @Override
    public void update(Team team) {
        repo.save(team);
    }

    @Override
    public Team findById(int id) throws ResourceNotFoundException {
        return repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Team not found with Id:" + id));
    }

    @Override
    public List<Team> findAll() {
        return repo.findAll();
    }
}
