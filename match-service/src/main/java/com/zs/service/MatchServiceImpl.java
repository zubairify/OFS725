package com.zs.service;

import com.zs.dto.MatchDto;
import com.zs.dto.TeamDto;
import com.zs.entity.Match;
import com.zs.error.ResourceNotFoundException;
import com.zs.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository repo;
    @Autowired
    private RestTemplate rest;

    @Value("${app.team.service.url}")
    private String teamServiceUrl;

    @Override
    public Match persist(Match match) throws ResourceNotFoundException {
        if(match.getHome() == match.getAway())
            throw new IllegalArgumentException("Home and away teams cant be same");

        // localhost:8081/teams/101
        try {
            TeamDto home = rest.getForObject(teamServiceUrl+"/" +
                    match.getHome(), TeamDto.class);
            TeamDto away = rest.getForObject(teamServiceUrl+"/" +
                    match.getAway(), TeamDto.class);
        } catch (RestClientException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

        return repo.save(match);
    }

    @Override
    public List<Match> findAll() {
        return repo.findAll();
    }

    @Override
    public MatchDto findById(long id) {
        Match match = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Match not found with Id: " + id));
        MatchDto matchDto = new MatchDto();
        matchDto.setId(match.getId());
        matchDto.setStadium(match.getStadium());
        matchDto.setMatchDate(match.getMatchDate());
        matchDto.setMatchTime(match.getMatchTime());
        matchDto.setHomeTeam(rest.getForObject(teamServiceUrl+"/" +
                match.getHome(), TeamDto.class));
        matchDto.setAwayTeam(rest.getForObject(teamServiceUrl+"/" +
                match.getAway(), TeamDto.class));

        return matchDto;
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
