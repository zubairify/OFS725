package com.zs.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MatchDto {
    private String stadium;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private int homeTeamId;
    private int awayTeamId;
}
