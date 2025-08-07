package com.zs.service;

import com.zs.dto.MatchDto;
import com.zs.entity.Match;
import com.zs.entity.Team;
import com.zs.error.ResourceNotFoundException;
import com.zs.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository repo;
    @Autowired
    private TeamService service;

    @Override
    public Match persist(MatchDto matchDto) throws ResourceNotFoundException {
        if(matchDto.getHomeTeamId() == matchDto.getAwayTeamId())
            throw new IllegalArgumentException("Home and away teams cant be same");

        Team home = service.findById(matchDto.getHomeTeamId());
        Team away = service.findById(matchDto.getAwayTeamId());

        Match match = new Match();
        match.setStadium(matchDto.getStadium());
        match.setMatchDate(matchDto.getMatchDate());
        match.setMatchTime(matchDto.getMatchTime());
        match.setHome(home);
        match.setAway(away);

        return repo.save(match);
    }

    @Override
    public List<Match> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Match> findByTeam(int tid) {
        return repo.findByTeam(tid);
    }

    @Override
    public List<Match> findByStadium(String stadium) {
        return repo.findByStadium(stadium);
    }

    @Override
    public List<Match> upcomingMatches() {
        return repo.findByMatchDateGreaterThan(LocalDate.now());
    }
}
