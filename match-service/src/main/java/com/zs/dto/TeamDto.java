package com.zs.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDto {
    private int teamId;
    private String teamName;
    private String owner;
    private String home;
    private double budget;
    private List<PlayerDto> players;
}
