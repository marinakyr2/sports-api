package com.example.sportsapi.repository;

import com.example.sportsapi.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, String> {
}
