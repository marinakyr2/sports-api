package com.example.sportsapi.dto;

import com.example.sportsapi.entity.enums.Sport;

import java.time.LocalDate;
import java.time.LocalTime;

public class MatchOddsDto {
    private String id;


    private String matchId;

    private String specifier;

    // Constructors, Getters, and Setters
    public MatchOddsDto() {
    }

    public MatchOddsDto(String id, String matchId, String specifier) {
        this.id = id;
        this.matchId = matchId;
        this.specifier = specifier;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

}
