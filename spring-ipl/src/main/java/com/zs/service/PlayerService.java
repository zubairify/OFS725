package com.zs.service;

import com.zs.entity.Player;
import com.zs.error.OutOfBudgetException;
import com.zs.error.PlayerAlreadySoldException;
import com.zs.error.ResourceNotFoundException;

import java.util.List;

public interface PlayerService {

    Player persist(Player player);
    Player addToTeam(int teamId, int jerseyNo)
            throws PlayerAlreadySoldException, OutOfBudgetException, ResourceNotFoundException;
    Player findByJersey(int jersey) throws ResourceNotFoundException;
    List<Player> findAll();
    List<Player> findByRole(String role);
    Player mostExpensive();
    Player leastExpensive();
    List<Player> findByBidAmount(double min, double max);
    List<Player> findBySoldStatus(boolean sold);
}
