package com.zs.controller;

import com.zs.entity.Team;
import com.zs.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService service;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Team> add(@RequestBody Team team) {
        Team t = service.persist(team);
        return ResponseEntity.ok(t);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Team> get(@PathVariable int id) {
        Team t = service.findById(id);
        return ResponseEntity.ok(t);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Team>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
