package com.zs.service;

import com.zs.entity.Player;
import com.zs.entity.Team;
import com.zs.error.OutOfBudgetException;
import com.zs.error.PlayerAlreadySoldException;
import com.zs.error.ResourceNotFoundException;
import com.zs.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repo;
    @Autowired
    private TeamService service;

    @Override
    public Player persist(Player player) {
        return repo.save(player);
    }

    @Override
    public Player addToTeam(int teamId, int jerseyNo) throws PlayerAlreadySoldException, OutOfBudgetException, ResourceNotFoundException {
        Team team = service.findById(teamId);
        Player player = findByJersey(jerseyNo);

        if(player.getTeam() != null)
            throw new PlayerAlreadySoldException("Player already sold");

        if(player.getBidAmount() > team.getBudget())
            throw new OutOfBudgetException("Player out of budget");

        team.setBudget(team.getBudget() - player.getBidAmount());
        player.setTeam(team);
        service.update(team);
        return repo.save(player);
    }

    @Override
    public Player findByJersey(int jersey) throws ResourceNotFoundException {
        return repo.findById(jersey).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Player not found with jersey no:" + jersey));
    }

    @Override
    public List<Player> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Player> findByRole(String role) {
        return repo.findByRole(role);
    }

    @Override
    public Player mostExpensive() {
        return repo.findFirstByOrderByBidAmountDesc();
    }

    @Override
    public Player leastExpensive() {
        return repo.findFirstByOrderByBidAmountAsc();
    }

    @Override
    public List<Player> findByBidAmount(double min, double max) {
        return repo.findByAmountWithin(min, max);
    }

    @Override
    public List<Player> findBySoldStatus(boolean sold) {
        return sold ? repo.findBySold() : repo.findByUnsold();
    }
}
