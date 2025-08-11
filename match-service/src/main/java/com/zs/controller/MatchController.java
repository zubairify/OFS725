package com.zs.controller;

import com.zs.dto.MatchDto;
import com.zs.entity.Match;
import com.zs.error.ResourceNotFoundException;
import com.zs.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private MatchService service;

    @Autowired
    public void setService(MatchService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Match> add(@RequestBody Match match) {
        return ResponseEntity.ok(service.persist(match));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> get(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Match>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/stadium/{stadium}")
    public ResponseEntity<List<Match>> findByStadium(@PathVariable("stadium") String stadium) {
        return ResponseEntity.ok(service.findByStadium(stadium));
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<List<Match>> findByTeam(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.findByTeam(id));
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Match>> findUpcoming() {
        return ResponseEntity.ok(service.upcomingMatches());
    }

}

