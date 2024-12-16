package com.example.sportsapi.controller;

import com.example.sportsapi.entity.MatchOdds;
import com.example.sportsapi.service.MatchOddsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-odds")
public class MatchOddsController {

    private final MatchOddsService matchOddsService;

    public MatchOddsController(MatchOddsService matchOddsService) {
        this.matchOddsService = matchOddsService;
    }

    @GetMapping
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsService.getAllMatchOdds();
    }

    @PostMapping
    public MatchOdds createMatchOdds(@RequestBody MatchOdds matchOdds) {
        return matchOddsService.createMatchOdds(matchOdds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@PathVariable String id) {
        return ResponseEntity.ok(matchOddsService.getMatchOddsById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchOdds> updateMatchOdds(@PathVariable String id, @RequestBody MatchOdds matchOdds) {
        return ResponseEntity.ok(matchOddsService.updateMatchOdds(id, matchOdds));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMatchOdds(@PathVariable String id) {
        matchOddsService.deleteMatchOdds(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}