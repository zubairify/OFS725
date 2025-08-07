package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id @Column(name = "team_id")
    private int teamId;
    @Column(name = "team_name", length = 30, nullable = false)
    private String teamName;
    @Column(length = 30, nullable = false)
    private String owner;
    @Column(length = 30, nullable = false)
    private String home;
    private double budget;

    @JsonManagedReference
    @OneToMany(mappedBy = "team")
    private List<Player> players;
}
