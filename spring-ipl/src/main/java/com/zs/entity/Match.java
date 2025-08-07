package com.zs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    private long id;

    @Column(length = 30, nullable = false)
    private String stadium;
    private LocalDate matchDate;
    private LocalTime matchTime;

    @OneToOne @JoinColumn(name = "home_team")
    private Team home;
    @OneToOne @JoinColumn(name = "away_team")
    private Team away;
}
