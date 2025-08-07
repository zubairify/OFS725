package com.zs.controller;

import com.zs.entity.Player;
import com.zs.error.ResourceNotFoundException;
import com.zs.service.PlayerService;
import com.zs.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService service;

    @PostMapping(value = "/add")
    public ResponseEntity<Player> add(@RequestBody Player player) {
        return ResponseEntity.ok(service.persist(player));
    }

    @GetMapping("/{no}")
    public ResponseEntity<Player> findById(@PathVariable int no) {
        return ResponseEntity.ok(service.findByJersey(no));
    }

    @GetMapping("/")
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Player>> findByRole(@PathVariable String role) {
        return ResponseEntity.ok(service.findByRole(role));
    }

    @PutMapping("/assign")
    public ResponseEntity<Player> assignTeam(
            @RequestParam int id, @RequestParam int no) {
        return ResponseEntity.ok(service.addToTeam(id, no));
    }

    @GetMapping("/most-exp")
    public ResponseEntity<Player> expensive() {
        return ResponseEntity.ok(service.mostExpensive());
    }

    @GetMapping("/least-exp")
    public ResponseEntity<Player> cheap() {
        return ResponseEntity.ok(service.leastExpensive());
    }

    @GetMapping("/range")
    public ResponseEntity<List<Player>> range(
            @RequestParam double min, @RequestParam double max) {
        return ResponseEntity.ok(service.findByBidAmount(min, max));
    }

    @GetMapping("/sold/{status}")
    public ResponseEntity<List<Player>> status(
            @PathVariable boolean status) {
        return ResponseEntity.ok(service.findBySoldStatus(status));
    }
}

