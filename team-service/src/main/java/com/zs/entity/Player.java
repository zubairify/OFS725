package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player {
    @Id @Column(name = "jersey_no")
    private int jerseyNo;
    @Column(name = "player_name", length = 30, nullable = false)
    private String playerName;
    @Column(length = 30, nullable = false)
    private String role;
    private double bidAmount;

    @JsonBackReference
    @ManyToOne @JoinColumn(name = "team_id")
    private Team team;
}
