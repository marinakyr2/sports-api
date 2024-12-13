package com.example.sportsapi.repository;

import com.example.sportsapi.entity.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {
}