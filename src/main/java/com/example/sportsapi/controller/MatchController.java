package com.example.sportsapi.controller;

import com.example.sportsapi.entity.Match;
import com.example.sportsapi.repository.MatchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        return matchRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        return matchRepository.findById(id)
                .map(existingMatch -> {
                    existingMatch.setDescription(match.getDescription());
                    existingMatch.setMatchDate(match.getMatchDate());
                    existingMatch.setMatchTime(match.getMatchTime());
                    existingMatch.setTeamA(match.getTeamA());
                    existingMatch.setTeamB(match.getTeamB());
                    existingMatch.setSport(match.getSport());
                    return ResponseEntity.ok(matchRepository.save(existingMatch));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMatch(@PathVariable Long id) {
        return matchRepository.findById(id)
                .map(match -> {
                    matchRepository.delete(match);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
