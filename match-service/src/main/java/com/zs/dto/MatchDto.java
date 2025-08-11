package com.zs.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MatchDto {
    private long id;
    private String stadium;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
}
