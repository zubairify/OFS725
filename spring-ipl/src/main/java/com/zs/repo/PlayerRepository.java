package com.zs.repo;

import com.zs.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

    List<Player> findByRole(String role);

    @Query("FROM Player p WHERE p.team IS NULL")
    List<Player> findByUnsold();

    @Query("FROM Player p WHERE p.team IS NOT NULL")
    List<Player> findBySold();

    Player findFirstByOrderByBidAmountDesc();

    Player findFirstByOrderByBidAmountAsc();

    @Query("FROM Player WHERE bidAmount BETWEEN :min AND :max")
    List<Player> findByAmountWithin(double min, double max);
    // -- OR --
//  List<Player> findByBidAmountBetween(double min, double max);
}
