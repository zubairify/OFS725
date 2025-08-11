package com.zs.service;

import com.zs.dto.MatchDto;
import com.zs.entity.Match;
import com.zs.error.ResourceNotFoundException;

import java.util.List;

public interface MatchService {

    Match persist(Match match) throws ResourceNotFoundException;

    List<Match> findAll();

    MatchDto findById(long id);

    List<Match> findByTeam(int tid);

    List<Match> findByStadium(String stadium);

    List<Match> upcomingMatches();
}
