package com.example.sportsapi.service;

import com.example.sportsapi.dto.MatchOddsDto;
import com.example.sportsapi.entity.MatchOdds;

import java.util.List;

public interface MatchOddsService {

    List<MatchOddsDto> getAllMatchOdds();

    void createMatchOdds(MatchOdds matchOdds);

    MatchOddsDto getMatchOddsById(String id);

    MatchOddsDto updateMatchOdds(String id, MatchOdds matchOdds);

    void deleteMatchOdds(String id);

}
