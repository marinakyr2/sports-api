package com.example.sportsapi.controller;

import com.example.sportsapi.dto.MatchOddsDto;
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
    public List<MatchOddsDto> getAllMatchOdds() {
        return matchOddsService.getAllMatchOdds();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createMatchOdds(@RequestBody MatchOdds matchOdds) {
        matchOddsService.createMatchOdds(matchOdds);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOddsDto> getMatchOddsById(@PathVariable String id) {
        return ResponseEntity.ok(matchOddsService.getMatchOddsById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchOddsDto> updateMatchOdds(@PathVariable String id, @RequestBody MatchOdds matchOdds) {
        return ResponseEntity.ok(matchOddsService.updateMatchOdds(id, matchOdds));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMatchOdds(@PathVariable String id) {
        matchOddsService.deleteMatchOdds(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}