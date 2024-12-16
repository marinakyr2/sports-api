package com.example.sportsapi.service;

import com.example.sportsapi.entity.MatchOdds;

import java.util.List;

public interface MatchOddsService {

    List<MatchOdds> getAllMatchOdds();

    MatchOdds createMatchOdds(MatchOdds matchOdds);

    MatchOdds getMatchOddsById(String id);

    MatchOdds updateMatchOdds(String id, MatchOdds matchOdds);

    void deleteMatchOdds(String id);

}
