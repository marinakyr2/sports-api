package com.example.sportsapi.controller;

import com.example.sportsapi.entity.Match;
import com.example.sportsapi.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping()
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping()
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable String id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable String id, @RequestBody Match match) {
        return ResponseEntity.ok(matchService.updateMatch(id, match));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMatch(@PathVariable String id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
