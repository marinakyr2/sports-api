package com.example.sportsapi.service;

import com.example.sportsapi.entity.Match;

import java.util.List;

public interface MatchService {

    List<Match> getAllMatches();

    Match getMatchById(String id);

    Match createMatch(Match match);

    Match updateMatch(String id, Match match);

    void deleteMatch(String id);

}
