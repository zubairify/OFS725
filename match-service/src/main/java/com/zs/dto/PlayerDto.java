package com.zs.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private int jerseyNo;
    private String playerName;
    private String role;
    private double bidAmount;
    private TeamDto team;
}
