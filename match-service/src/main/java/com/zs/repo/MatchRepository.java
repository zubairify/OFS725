package com.zs.repo;

import com.zs.dto.MatchDto;
import com.zs.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("FROM Match m WHERE m.home=:tid OR m.away=:tid")
    List<Match> findByTeam(int tid);

    List<Match> findByStadium(String stadium);

    List<Match> findByMatchDateGreaterThan(LocalDate date);
}
