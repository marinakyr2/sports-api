package com.example.sportsapi.service;

import com.example.sportsapi.dto.MatchDto;
import com.example.sportsapi.entity.Match;

import java.util.List;

public interface MatchService {

    List<MatchDto> getAllMatches();

    MatchDto getMatchById(String id);

    void createMatch(Match match);

    MatchDto updateMatch(String id, Match match);

    void deleteMatch(String id);

}
