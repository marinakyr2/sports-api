package com.example.sportsapi.entity;

import jakarta.persistence.*;

@Entity
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String matchId;

    private String specifier;

    public MatchOdds(String matchId, String specifier, Double odd) {
        this.matchId = matchId;
        this.specifier = specifier;
        this.odd = odd;
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

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    private Double odd;


}